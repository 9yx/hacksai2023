package ru.runx.lempact.dto.yt

/**
 * Internal representation of thumbnails for a YouTube resource.
 */
data class ThumbnailDetails(
    /**
     * The default image for this resource.
     * The value may be `null`.
     */
    val default: Thumbnail? = null,
    /**
     * The high quality image for this resource.
     * The value may be `null`.
     */
    val high: Thumbnail? = null,
    /**
     * The maximum resolution quality image for this resource.
     * The value may be `null`.
     */
    val maxres: Thumbnail? = null,
    /**
     * The medium quality image for this resource.
     * The value may be `null`.
     */
    val medium: Thumbnail? = null,
    /**
     * The standard quality image for this resource.
     * The value may be `null`.
     */
    val standard: Thumbnail? = null
)
