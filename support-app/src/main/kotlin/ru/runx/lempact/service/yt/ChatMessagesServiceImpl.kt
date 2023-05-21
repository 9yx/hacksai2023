package ru.runx.lempact.service.yt

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import ru.runx.lempact.dto.yt.LiveChatMessage
import ru.runx.lempact.dto.yt.LiveChatMessageListResponse
import ru.runx.lempact.dto.yt.LiveChatMessageSnippet
import ru.runx.lempact.dto.yt.LiveChatTextMessageDetails
import ru.runx.lempact.enums.yt.LiveChatMessagePart
import ru.runx.lempact.enums.yt.VideosPart
import ru.runx.lempact.exception.yt.YtException
import java.time.Duration

@Service
class ChatMessagesServiceImpl(
    private val ytLiveChat: YtLiveChat,
    private val ytVideos: YtVideos,
) : ChatMessagesService {

    private val logger = LoggerFactory.getLogger(ChatMessagesServiceImpl::class.java)

    override fun videoId4LiveChatId(videoId: String): Mono<String> {
        return ytVideos.videoById(
            part = listOf(VideosPart.liveStreamingDetails),
            id = videoId
        ).mapNotNull {
            if (it.items?.isNotEmpty() == true) {
                it.items[0].liveStreamingDetails?.activeLiveChatId
                    ?: throw YtException("Error activeLiveChatId is null in videoId: $videoId")
            } else {
                throw YtException("Error empty liveStreamingDetails in videoId: $videoId")
            }
        }
    }

    override fun sendMessage(liveChatId: String, messageText: String): Mono<LiveChatMessage> {
        return ytLiveChat.insert(
            part = LiveChatMessagePart.snippet,
            body = LiveChatMessage(
                snippet = LiveChatMessageSnippet(
                    liveChatId = liveChatId,
                    type = "textMessageEvent",
                    textMessageDetails = LiveChatTextMessageDetails(
                        messageText = messageText
                    )
                )
            )
        )
    }

    private fun printLogs(messageListResponse: LiveChatMessageListResponse) {
        this.logger.info("____________________________________________________________")
        this.logger.info(
            "New portion logs size: {}, delay: {}",
            messageListResponse.items?.size,
            messageListResponse.pollingIntervalMillis
        )
        messageListResponse.items?.forEach {
            this.logger.info(
                "{}-{}: {}", it.snippet?.publishedAt?.value,
                it.snippet?.authorChannelId,
                it.snippet?.displayMessage
            )
        }
    }

    override fun polling(liveChatId: String): Mono<LiveChatMessageListResponse> {
        var nextPageToken: String? = null
        var pollingIntervalMillis: Long = 10000
        return Mono.defer {
            ytLiveChat.messages(
                liveChatId = liveChatId,
                part = LiveChatMessagePart.snippet,
                pageToken = nextPageToken
            )
        }
            .flatMap {
                nextPageToken = it.nextPageToken
                pollingIntervalMillis = it.pollingIntervalMillis ?: 10000
                Mono.fromCallable {
                    printLogs(it)
                    it
                }.subscribeOn(Schedulers.boundedElastic())
            }
            .delayUntil {
                Mono.delay(Duration.ofMillis(it.pollingIntervalMillis ?: 10000))
            }
            .repeat()
            .takeUntil {
                it.nextPageToken == null
            }
            .last()
    }
}
