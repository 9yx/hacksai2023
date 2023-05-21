package ru.runx.lempact.dto.yt

/**
 * Details about the content of a YouTube Video.
 */
data class VideoContentDetails(
    /**
     * The value of captions indicates whether the video has captions or not.
     * The value may be `null`.
     */
    val caption: String? = null,
    /**
     * Specifies the ratings that the video received under various rating schemes.
     * The value may be `null`.
     */
    val contentRating: ContentRating? = null,
    /**
     * The countryRestriction object contains information about the countries where a video is (or is
     * not) viewable.
     * The value may be `null`.
     */
    val countryRestriction: AccessPolicy? = null,
    /**
     * The value of definition indicates whether the video is available in high definition or only in
     * standard definition.
     * The value may be `null`.
     */
    val definition: String? = null,
    /**
     * The value of dimension indicates whether the video is available in 3D or in 2D.
     * The value may be `null`.
     */
    val dimension: String? = null,
    /**
     * The length of the video. The tag value is an ISO 8601 duration in the format PT#M#S, in which
     * the letters PT indicate that the value specifies a period of time, and the letters M and S
     * refer to length in minutes and seconds, respectively. The # characters preceding the M and S
     * letters are both integers that specify the number of minutes (or seconds) of the video. For
     * example, a value of PT15M51S indicates that the video is 15 minutes and 51 seconds long.
     * The value may be `null`.
     */
    val duration: String? = null,
    /**
     * Indicates whether the video uploader has provided a custom thumbnail image for the video. This
     * property is only visible to the video uploader.
     * The value may be `null`.
     */
    val hasCustomThumbnail: Boolean? = null,
    /**
     * The value of is_license_content indicates whether the video is licensed content.
     * The value may be `null`.
     */
    val licensedContent: Boolean? = null,
    /**
     * Specifies the projection format of the video.
     * The value may be `null`.
     */
    val projection: String? = null,
    /**
     * The regionRestriction object contains information about the countries where a video is (or is
     * not) viewable. The object will contain either the contentDetails.regionRestriction.allowed
     * property or the contentDetails.regionRestriction.blocked property.
     * The value may be `null`.
     */
    val regionRestriction: VideoContentDetailsRegionRestriction? = null,
)
