package ru.runx.lempact.dto.yt

/**
 * Localized versions of certain video properties (e.g. title).
 */
data class VideoLocalization(
    /**
     * Localized version of the video's description.
     * The value may be `null`.
     */
    val description: String? = null,
    /**
     * Localized version of the video's title.
     * The value may be `null`.
     */
    val title: String? = null
)
