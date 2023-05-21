package ru.runx.lempact.dto.yt

/**
 * A *channel* resource contains information about a YouTube channel.
 */
data class Channel(
    /**
     * The auditionDetails object encapsulates channel data that is relevant for YouTube Partners
     * during the audition process.
     * The value may be `null`.
     */
    var auditDetails: ChannelAuditDetails? = null,

    /**
     * The brandingSettings object encapsulates information about the branding of the channel.
     * The value may be `null`.
     */
    val brandingSettings: ChannelBrandingSettings? = null,
    /**
     * The contentDetails object encapsulates information about the channel's content.
     * The value may be `null`.
     */
    val contentDetails: ChannelContentDetails? = null,
    /**
     * The contentOwnerDetails object encapsulates channel data that is relevant for YouTube Partners
     * linked with the channel.
     * The value may be `null`.
     */
    val contentOwnerDetails: ChannelContentOwnerDetails? = null,
    /**
     * The conversionPings object encapsulates information about conversion pings that need to be
     * respected by the channel.
     * The value may be `null`.
     */
    val conversionPings: ChannelConversionPings? = null,
    /**
     * Etag of this resource.
     * The value may be `null`.
     */
    val etag: String? = null,
    /**
     * The ID that YouTube uses to uniquely identify the channel.
     * The value may be `null`.
     */
    val id: String? = null,
    /**
     * Identifies what kind of resource this is. Value: the fixed string "youtube#channel".
     * The value may be `null`.
     */
    val kind: String? = null,
    /**
     * Localizations for different languages
     * The value may be `null`.
     */
    val localizations: Map<String, ChannelLocalization>? = null,
    /**
     * The snippet object contains basic details about the channel, such as its title, description,
     * and thumbnail images.
     * The value may be `null`.
     */
    val snippet: ChannelSnippet? = null,
    /**
     * The statistics object encapsulates statistics for the channel.
     * The value may be `null`.
     */
    val statistics: ChannelStatistics? = null,
    /**
     * The status object encapsulates information about the privacy status of the channel.
     * The value may be `null`.
     */
    val status: ChannelStatus? = null,
    /**
     * The topicDetails object encapsulates information about Freebase topics associated with the
     * channel.
     * The value may be `null`.
     */
    val topicDetails: ChannelTopicDetails? = null
)
