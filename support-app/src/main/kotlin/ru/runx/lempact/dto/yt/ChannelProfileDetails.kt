package ru.runx.lempact.dto.yt

/**
 * Model definition for ChannelProfileDetails.
 */
data class ChannelProfileDetails(
    /**
     * The YouTube channel ID.
     * The value may be `null`.
     */
    val channelId: String? = null,
    /**
     * The channel's URL.
     * The value may be `null`.
     */
    val channelUrl: String? = null,
    /**
     * The channel's display name.
     * The value may be `null`.
     */
    val displayName: String? = null,
    /**
     * The channels's avatar URL.
     * The value may be `null`.
     */
    val profileImageUrl: String? = null
)
