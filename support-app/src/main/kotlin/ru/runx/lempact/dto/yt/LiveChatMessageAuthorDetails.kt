package ru.runx.lempact.dto.yt

/**
 * Model definition for LiveChatMessageAuthorDetails.
 */
data class LiveChatMessageAuthorDetails(
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
     * Whether the author is a moderator of the live chat.
     * The value may be `null`.
     */
    val isChatModerator: Boolean? = null,
    /**
     * Whether the author is the owner of the live chat.
     * The value may be `null`.
     */
    val isChatOwner: Boolean? = null,
    /**
     * Whether the author is a sponsor of the live chat.
     * The value may be `null`.
     */
    val isChatSponsor: Boolean? = null,
    /**
     * Whether the author's identity has been verified by YouTube.
     * The value may be `null`.
     */
    val isVerified: Boolean? = null,
    /**
     * The channels's avatar URL.
     * The value may be `null`.
     */
    val profileImageUrl: String? = null
)
