package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Statistics about a channel: number of subscribers, number of videos in the channel, etc
 */
data class ChannelStatistics(
    /**
     * The number of comments for the channel.
     * The value may be `null`.
     */
    val commentCount: BigInteger? = null,
    /**
     * Whether or not the number of subscribers is shown for this user.
     * The value may be `null`.
     */
    val hiddenSubscriberCount: Boolean? = null,
    /**
     * The number of subscribers that the channel has.
     * The value may be `null`.
     */
    val subscriberCount: BigInteger? = null,
    /**
     * The number of videos uploaded to the channel.
     * The value may be `null`.
     */
    val videoCount: BigInteger? = null,
    /**
     * The number of times the channel has been viewed.
     * The value may be `null`.
     */
    val viewCount: BigInteger? = null
)
