package ru.runx.lempact.dto.yt

/**
 * Player to be used for a video playback.
 */
data class VideoPlayer(
    /**
     * The value may be `null`.
     */
    val embedHeight: Long? = null,
    /**
     * An  tag that embeds a player that will play the video.
     * The value may be `null`.
     */
    val embedHtml: String? = null,
    /**
     * The embed width
     * The value may be `null`.
     */
    val embedWidth: Long? = null
)
