package ru.runx.lempact.dto.yt

/**
 * Branding properties for the watch. All deprecated.
 */
@Deprecated("Branding properties for the watch. All deprecated.")
data class WatchSettings(
    /**
     * The text color for the video watch page's branded area.
     * The value may be `null`.
     */
    val backgroundColor: String? = null,

    /**
     * An ID that uniquely identifies a playlist that displays next to the video player.
     * The value may be `null`.
     */
    val featuredPlaylistId: String? = null,

    /**
     * The background color for the video watch page's branded area.
     * The value may be `null`.
     */
    val textColor: String? = null
)
