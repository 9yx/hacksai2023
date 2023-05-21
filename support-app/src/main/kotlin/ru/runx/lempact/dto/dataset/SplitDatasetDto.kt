package ru.runx.lempact.dto.dataset

import java.nio.file.Path

data class SplitDatasetDto(
    val dirs: List<Folder>,

)

data class Folder(
    val dir: Path,
    val tag: String
)

