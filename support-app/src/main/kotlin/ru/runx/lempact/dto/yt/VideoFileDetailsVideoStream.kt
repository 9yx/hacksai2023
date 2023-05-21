package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Information about a video stream.
 */
data class VideoFileDetailsVideoStream(
    /**
     * The video content's display aspect ratio, which specifies the aspect ratio in which the video
     * should be displayed.
     * The value may be `null`.
     */
    val aspectRatio: Double? = null,
    /**
     * The video stream's bitrate, in bits per second.
     * The value may be `null`.
     */
    val bitrateBps: BigInteger? = null,
    /**
     * The video codec that the stream uses.
     * The value may be `null`.
     */
    val codec: String? = null,
    /**
     * The video stream's frame rate, in frames per second.
     * The value may be `null`.
     */
    val frameRateFps: Double? = null,
    /**
     * The encoded video content's height in pixels.
     * The value may be `null`.
     */
    val heightPixels: Long? = null,
    /**
     * The amount that YouTube needs to rotate the original source content to properly display the
     * video.
     * The value may be `null`.
     */
    val rotation: String? = null,
    /**
     * A value that uniquely identifies a video vendor. Typically, the value is a four-letter vendor
     * code.
     * The value may be `null`.
     */
    val vendor: String? = null,
    /**
     * The encoded video content's width in pixels. You can calculate the video's encoding aspect
     * ratio as width_pixels / height_pixels.
     * The value may be `null`.
     */
    val widthPixels: Long? = null
)
