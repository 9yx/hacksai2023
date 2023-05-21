package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * Basic details about a video, including title, description, uploader, thumbnails and category.
 */
data class VideoSnippet(
    /**
     * The YouTube video category associated with the video.
     * The value may be `null`.
     */
    val categoryId: String? = null,
    /**
     * The ID that YouTube uses to uniquely identify the channel that the video was uploaded to.
     * The value may be `null`.
     */
    val channelId: String? = null,
    /**
     * Channel title for the channel that the video belongs to.
     * The value may be `null`.
     */
    val channelTitle: String? = null,
    /**
     * The default_audio_language property specifies the language spoken in the video's default audio
     * track.
     * The value may be `null`.
     */
    val defaultAudioLanguage: String? = null,
    /**
     * The language of the videos's default snippet.
     * The value may be `null`.
     */
    val defaultLanguage: String? = null,
    /**
     * The video's description. @mutable youtube.videos.insert youtube.videos.update
     * The value may be `null`.
     */
    val description: String? = null,
    /**
     * Indicates if the video is an upcoming/active live broadcast. Or it's "none" if the video is not
     * an upcoming/active live broadcast.
     * The value may be `null`.
     */
    val liveBroadcastContent: String? = null,
    /**
     * Localized snippet selected with the hl parameter. If no such localization exists, this field is
     * populated with the default snippet. (Read-only)
     * The value may be `null`.
     */
    val localized: VideoLocalization? = null,
    /**
     * The date and time when the video was uploaded.
     * The value may be `null`.
     */
    val publishedAt: DateTime? = null,
    /**
     * A list of keyword tags associated with the video. Tags may contain spaces.
     * The value may be `null`.
     */
    val tags: List<String>? = null,
    /**
     * A map of thumbnail images associated with the video. For each object in the map, the key is the
     * name of the thumbnail image, and the value is an object that contains other information about
     * the thumbnail.
     * The value may be `null`.
     */
    val thumbnails: ThumbnailDetails? = null,
    /**
     * The video's title. @mutable youtube.videos.insert youtube.videos.update
     * The value may be `null`.
     */
    val title: String? = null
)
