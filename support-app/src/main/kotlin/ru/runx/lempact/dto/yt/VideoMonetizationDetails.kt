package ru.runx.lempact.dto.yt

/**
 * Details about monetization of a YouTube Video.
 */
data class VideoMonetizationDetails(
    /**
     * The value of access indicates whether the video can be monetized or not.
     * The value may be `null`.
     */
    val access: AccessPolicy? = null
)
