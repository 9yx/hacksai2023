package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Statistics about the video, such as the number of times the video was viewed or liked.
 */
data class VideoStatistics(
    /**
     * The number of comments for the video.
     * The value may be `null`.
     */
    val commentCount: BigInteger? = null,
    /**
     * The number of users who have indicated that they disliked the video by giving it a negative
     * rating.
     * The value may be `null`.
     */
    val dislikeCount: BigInteger? = null,
    /**
     * The number of users who currently have the video marked as a favorite video.
     * The value may be `null`.
     */
    val favoriteCount: BigInteger? = null,
    /**
     * The number of users who have indicated that they liked the video by giving it a positive
     * rating.
     * The value may be `null`.
     */
    val likeCount: BigInteger? = null,
    /**
     * The number of times the video has been viewed.
     * The value may be `null`.
     */
    val viewCount: BigInteger? = null
)
