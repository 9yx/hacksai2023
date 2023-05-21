package ru.runx.lempact.config

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import ru.runx.lempact.enums.yt.VideosPart

@Component
class StringToListVideoPartConverter : Converter<String, List<VideosPart>> {
    override fun convert(source: String): List<VideosPart> {
        return source.split(",")
            .dropLastWhile {
                it.isEmpty()
            }
            .map {
                VideosPart.valueOf(it)
            }
    }
}

@Component
class VideoPartListToStringConverter : Converter<List<VideosPart>, String> {

    override fun convert(source: List<VideosPart>): String? {
        return source.joinToString(",") {
            it.name
        }
    }
}
