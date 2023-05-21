package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * Basic details about a video category, such as its localized title. Next Id: 18
 */
data class VideoStatus(
    /**
     * This value indicates if the video can be embedded on another website. @mutable
     * youtube.videos.insert youtube.videos.update
     * The value may be `null`.
     */
    val embeddable: Boolean? = null,
    /**
     * This value explains why a video failed to upload. This property is only present if the
     * uploadStatus property indicates that the upload failed.
     * The value may be `null`.
     */
    val failureReason: String? = null,
    /**
     * The video's license. @mutable youtube.videos.insert youtube.videos.update
     * The value may be `null`.
     */
    val license: String? = null,
    /**
     * The value may be `null`.
     */
    val madeForKids: Boolean? = null,
    /**
     * The video's privacy status.
     * The value may be `null`.
     */
    val privacyStatus: String? = null,
    /**
     * This value indicates if the extended video statistics on the watch page can be viewed by
     * everyone. Note that the view count, likes, etc will still be visible if this is disabled.
     * @mutable youtube.videos.insert youtube.videos.update
     * The value may be `null`.
     */
    val publicStatsViewable: Boolean? = null,
    /**
     * The date and time when the video is scheduled to publish. It can be set only if the privacy
     * status of the video is private..
     * The value may be `null`.
     */
    val publishAt: DateTime? = null,
    /**
     * This value explains why YouTube rejected an uploaded video. This property is only present if
     * the uploadStatus property indicates that the upload was rejected.
     * The value may be `null`.
     */
    val rejectionReason: String? = null,
    /**
     * The value may be `null`.
     */
    val selfDeclaredMadeForKids: Boolean? = null,
    /**
     * The status of the uploaded video.
     * The value may be `null`.
     */
    val uploadStatus: String? = null
)
