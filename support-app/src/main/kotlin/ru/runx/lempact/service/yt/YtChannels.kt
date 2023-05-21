package ru.runx.lempact.service.yt

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono
import ru.runx.lempact.enums.yt.ChannelsPart
import ru.runx.lempact.dto.yt.ChannelListResponse

interface YtChannels {

    @GetExchange("/channels")
    fun channelById(
        @RequestParam part: List<ChannelsPart>,
        @RequestParam id: String,
    ): Mono<ChannelListResponse>

}
