package ru.runx.lempact.dto.yt

/**
 * Branding properties of a YouTube channel.
 */
data class ChannelBrandingSettings(
    /**
     * Branding properties for the channel view.
     * The value may be `null`.
     */
    val channel: ChannelSettings? = null,

    /**
     * Additional experimental branding properties.
     * The value may be `null`.
     */
    val hints: List<PropertyValue>? = null,

    /**
     * Branding properties for branding images.
     * The value may be `null`.
     */
    val image: ImageSettings? = null,

    /**
     * Branding properties for the watch page.
     * The value may be `null`.
     */
    val watch: WatchSettings? = null
)
