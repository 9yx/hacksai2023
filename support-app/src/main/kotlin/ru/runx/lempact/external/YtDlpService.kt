package ru.runx.lempact.external

import java.nio.file.Path

interface YtDlpService {

    /**
     * Download video from youtube
     */
    fun downloadVideo(videoId: String): Path
}
