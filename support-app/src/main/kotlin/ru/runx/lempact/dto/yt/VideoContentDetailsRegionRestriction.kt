package ru.runx.lempact.dto.yt

/**
 * DEPRECATED Region restriction of the video.
 */
@Deprecated("DEPRECATED Region restriction of the video.")
data class VideoContentDetailsRegionRestriction(
    /**
     * A list of region codes that identify countries where the video is viewable. If this property is
     * present and a country is not listed in its value, then the video is blocked from appearing in
     * that country. If this property is present and contains an empty list, the video is blocked in
     * all countries.
     * The value may be `null`.
     */
    val allowed: List<String>? = null,

    /**
     * A list of region codes that identify countries where the video is blocked. If this property is
     * present and a country is not listed in its value, then the video is viewable in that country.
     * If this property is present and contains an empty list, the video is viewable in all countries.
     * The value may be `null`.
     */
    val blocked: List<String>? = null
)
