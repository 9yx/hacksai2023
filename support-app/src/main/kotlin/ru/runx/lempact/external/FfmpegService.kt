package ru.runx.lempact.external

import java.nio.file.Path

interface FfmpegService {

    /**
     * Break video in images
     */
    fun breakIntoImages(videoPath: Path, resultDirectory: String, fps: String = "1/60")
}
