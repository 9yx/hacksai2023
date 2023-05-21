package ru.runx.lempact.service.yt

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange
import reactor.core.publisher.Mono
import ru.runx.lempact.dto.yt.LiveChatMessage
import ru.runx.lempact.dto.yt.LiveChatMessageListResponse
import ru.runx.lempact.enums.yt.LiveChatMessagePart

interface YtLiveChat {

    @PostExchange(
        "/liveChat/messages",
    )
    fun insert(
        @RequestParam part: LiveChatMessagePart,
        @RequestBody body: LiveChatMessage
    ): Mono<LiveChatMessage>

    @GetExchange("/liveChat/messages")
    fun messages(
        @RequestParam liveChatId: String,
        @RequestParam part: LiveChatMessagePart,
        @RequestParam(required = false) hl: String? = null,
        @RequestParam(required = false) maxResults: UInt = 500U,
        @RequestParam(required = false) pageToken: String? = null,
        @RequestParam(required = false) profileImageSize: UInt = 88U
    ): Mono<LiveChatMessageListResponse>

}
