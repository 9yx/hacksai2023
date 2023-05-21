package ru.runx.lempact.dto.yt

/**
 * Model definition for VideoAgeGating.
 */
data class VideoAgeGating(
    /**
     * Indicates whether or not the video has alcoholic beverage content. Only users of legal
     * purchasing age in a particular country, as identified by ICAP, can view the content.
     * The value may be `null`.
     */
    val alcoholContent: Boolean? = null,
    /**
     * Age-restricted trailers. For redband trailers and adult-rated video-games. Only users aged 18+
     * can view the content. The the field is true the content is restricted to viewers aged 18+.
     * Otherwise The field won't be present.
     * The value may be `null`.
     */
    val restricted: Boolean? = null,
    /**
     * Video game rating, if any.
     * The value may be `null`.
     */
    val videoGameRating: String? = null
)
