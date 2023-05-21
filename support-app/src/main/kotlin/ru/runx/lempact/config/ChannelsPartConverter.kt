package ru.runx.lempact.config

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import ru.runx.lempact.enums.yt.ChannelsPart

class ChannelsPartConverter {
}


@Component
class StringToListChannelsPartConverter : Converter<String, List<ChannelsPart>> {
    override fun convert(source: String): List<ChannelsPart> {
        return source.split(",")
            .dropLastWhile {
                it.isEmpty()
            }
            .map {
                ChannelsPart.valueOf(it)
            }
    }
}

@Component
class ChannelsPartListToStringConverter : Converter<List<ChannelsPart>, String> {

    override fun convert(source: List<ChannelsPart>): String? {
        return source.joinToString(",") {
            it.name
        }
    }
}
