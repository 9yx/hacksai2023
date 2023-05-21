package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Model definition for LiveChatUserBannedMessageDetails.
 */
data class LiveChatUserBannedMessageDetails(
    /**
     * The duration of the ban. This property is only present if the banType is temporary.
     * The value may be `null`.
     */
    val banDurationSeconds: BigInteger? = null,
    /**
     * The type of ban.
     * The value may be `null`.
     */
    val banType: String? = null,
    /**
     * The details of the user that was banned.
     * The value may be `null`.
     */
    val bannedUserDetails: ChannelProfileDetails? = null
)
