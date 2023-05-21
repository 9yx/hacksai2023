package ru.runx.lempact.service.yt

import reactor.core.publisher.Mono
import ru.runx.lempact.dto.yt.LiveChatMessage
import ru.runx.lempact.dto.yt.LiveChatMessageListResponse

interface ChatMessagesService {

    /**
     * Exchange [videoId], return liveChatId
     */
    fun videoId4LiveChatId(videoId: String): Mono<String>

    /**
     * Send [message] to chat return true
     */
    fun sendMessage(liveChatId: String, messageText: String): Mono<LiveChatMessage>

    /**
     * Polling stream messages
     */
    fun polling(liveChatId: String): Mono<LiveChatMessageListResponse>

}
