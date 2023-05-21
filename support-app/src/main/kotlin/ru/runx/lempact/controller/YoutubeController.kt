package ru.runx.lempact.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import ru.runx.lempact.dto.yt.LiveChatMessage
import ru.runx.lempact.dto.yt.LiveChatMessageListResponse
import ru.runx.lempact.dto.yt.SearchListResponse
import ru.runx.lempact.enums.yt.SearchSort
import ru.runx.lempact.external.YtDlpService
import ru.runx.lempact.service.yt.*
import java.nio.file.Path

@RestController
@RequestMapping("/api/v1")
class YoutubeController(
    private val ytSearch: YtSearch,
    private val chatMessagesService: ChatMessagesService,
    private val ytDlpService: YtDlpService
) {

    @GetMapping("/yt/download/{videoId}")
    fun downloadVideo(
        @PathVariable videoId: String
    ): Mono<Path> {
        return Mono.fromCallable {
            ytDlpService.downloadVideo(
                videoId = videoId
            )
        }
            .subscribeOn(Schedulers.boundedElastic())
            .map {
                it.toAbsolutePath()
            }
    }

    @GetMapping("/auth/yt/sendMessage/{videoId}/{message}")
    fun sendMessage(
        @PathVariable videoId: String,
        @PathVariable message: String
    ): Mono<LiveChatMessage> {
        return chatMessagesService.videoId4LiveChatId(videoId).flatMap { liveChatId ->
            chatMessagesService.sendMessage(
                liveChatId,
                message
            )
        }
    }

    @GetMapping("/auth/yt/getChannelVideo/{channelId}")
    fun getInfo(@PathVariable channelId: String): Mono<SearchListResponse> {
        return ytSearch.byChannelId(
            channelId,
            10,
            SearchSort.VIEW_COUNT
        )
    }

    @GetMapping("/auth/yt/pollingChatMessages/{videoId}")
    fun pollingChatMessages(@PathVariable videoId: String): Mono<LiveChatMessageListResponse> {
        return chatMessagesService.videoId4LiveChatId(videoId).flatMap { liveChatId ->
            chatMessagesService.polling(liveChatId)
        }
    }
}
