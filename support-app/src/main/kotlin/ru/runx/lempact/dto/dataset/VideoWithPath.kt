package ru.runx.lempact.dto.dataset

import java.nio.file.Path

data class VideoWithPath(
    val video: Video,
    val path: Path
)
