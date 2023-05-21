package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * Recording information associated with the video.
 */
data class VideoRecordingDetails(
    /**
     * The geolocation information associated with the video.
     * The value may be `null`.
     */
    val location: GeoPoint? = null,
    /**
     * The text description of the location where the video was recorded.
     * The value may be `null`.
     */
    val locationDescription: String? = null,
    /**
     * The date and time when the video was recorded.
     * The value may be `null`.
     */
    val recordingDate: DateTime? = null
)
