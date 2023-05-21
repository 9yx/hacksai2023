package ru.runx.lempact.dto.yt

/**
 * Branding properties for the channel view.
 */
data class ChannelSettings(
    /**
     * The country of the channel.
     * The value may be `null`.
     */
    val country: String? = null,
    /**
     * The value may be `null`.
     */
    val defaultLanguage: String? = null,
    /**
     * Which content tab users should see when viewing the channel.
     * The value may be `null`.
     */
    val defaultTab: String? = null,
    /**
     * Specifies the channel description.
     * The value may be `null`.
     */
    val description: String? = null,
    /**
     * Title for the featured channels tab.
     * The value may be `null`.
     */
    val featuredChannelsTitle: String? = null,
    /**
     * The list of featured channels.
     * The value may be `null`.
     */
    val featuredChannelsUrls: List<String>? = null,
    /**
     * Lists keywords associated with the channel, comma-separated.
     * The value may be `null`.
     */
    val keywords: String? = null,
    /**
     * Whether user-submitted comments left on the channel page need to be approved by the channel
     * owner to be publicly visible.
     * The value may be `null`.
     */
    val moderateComments: Boolean? = null,
    /**
     * A prominent color that can be rendered on this channel page.
     * The value may be `null`.
     */
    val profileColor: String? = null,
    /**
     * Whether the tab to browse the videos should be displayed.
     * The value may be `null`.
     */
    val showBrowseView: Boolean? = null,
    /**
     * Whether related channels should be proposed.
     * The value may be `null`.
     */
    val showRelatedChannels: Boolean? = null,
    /**
     * Specifies the channel title.
     * The value may be `null`.
     */
    val title: String? = null,
    /**
     * The ID for a Google Analytics account to track and measure traffic to the channels.
     * The value may be `null`.
     */
    val trackingAnalyticsAccountId: String? = null,
    /**
     * The trailer of the channel, for users that are not subscribers.
     * The value may be `null`.
     */
    val unsubscribedTrailer: String? = null
)
