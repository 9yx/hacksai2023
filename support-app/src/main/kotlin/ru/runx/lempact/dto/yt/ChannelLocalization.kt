package ru.runx.lempact.dto.yt

/**
 * Channel localization setting
 */
data class ChannelLocalization(
    /**
     * The localized strings for channel's description.
     * The value may be `null`.
     */
    val description: String? = null,

    /**
     * The localized strings for channel's title.
     * The value may be `null`.
     */
    val title: String? = null
)
