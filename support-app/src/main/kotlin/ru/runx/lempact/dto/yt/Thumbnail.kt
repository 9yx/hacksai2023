package ru.runx.lempact.dto.yt

/**
 * A thumbnail is an image representing a YouTube resource.
 */
data class Thumbnail(
    /**
     * (Optional) Height of the thumbnail image.
     * The value may be `null`.
     */
    val height: Long? = null,
    /**
     * The thumbnail image's URL.
     * The value may be `null`.
     */
    val url: String? = null,
    /**
     * (Optional) Width of the thumbnail image.
     * The value may be `null`.
     */
    val width: Long? = null
)
