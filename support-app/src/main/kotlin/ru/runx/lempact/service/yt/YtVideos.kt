package ru.runx.lempact.service.yt

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono
import ru.runx.lempact.dto.yt.VideoListResponse
import ru.runx.lempact.enums.yt.VideosPart

interface YtVideos {

    @GetExchange("/videos")
    fun videoById(
        @RequestParam part: List<VideosPart>,
        @RequestParam id: String,
    ): Mono<VideoListResponse>
}
