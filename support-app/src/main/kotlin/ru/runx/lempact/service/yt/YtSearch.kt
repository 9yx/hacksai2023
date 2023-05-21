package ru.runx.lempact.service.yt

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono
import ru.runx.lempact.dto.yt.SearchListResponse
import ru.runx.lempact.enums.yt.SearchSort

interface YtSearch {

    @GetExchange("/search?part=snippet&type=video")
    fun byChannelId(
        @RequestParam(required = false) channelId: String? = null,
        @RequestParam maxResults: Int,
        @RequestParam sort: SearchSort
    ): Mono<SearchListResponse>
}
