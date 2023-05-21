package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Information about an audio stream.
 */
data class VideoFileDetailsAudioStream(
    /**
     * The audio stream's bitrate, in bits per second.
     * The value may be `null`.
     */
    val bitrateBps: BigInteger? = null,
    /**
     * The number of audio channels that the stream contains.
     * The value may be `null`.
     */
    val channelCount: Long? = null,
    /**
     * The audio codec that the stream uses.
     * The value may be `null`.
     */
    val codec: String? = null,
    /**
     * A value that uniquely identifies a video vendor. Typically, the value is a four-letter vendor
     * code.
     * The value may be `null`.
     */
    val vendor: String? = null
)
