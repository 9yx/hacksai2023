package ru.runx.lempact.external

import java.nio.file.Path


interface PredictService {
    fun predictDirectory(path: Path, project: String, name: String): Path
}
