package ru.runx.lempact.dto.yt

/**
 * Specifies suggestions on how to improve video content, including encoding hints, tag suggestions, and editor suggestions.
 */
data class VideoSuggestions(
    /**
     * A list of video editing operations that might improve the video quality or playback experience
     * of the uploaded video.
     * The value may be `null`.
     */
    val editorSuggestions: List<String?>? = null,
    /**
     * A list of errors that will prevent YouTube from successfully processing the uploaded video
     * video. These errors indicate that, regardless of the video's current processing status,
     * eventually, that status will almost certainly be failed.
     * The value may be `null`.
     */
    val processingErrors: List<String>? = null,
    /**
     * A list of suggestions that may improve YouTube's ability to process the video.
     * The value may be `null`.
     */
    val processingHints: List<String>? = null,
    /**
     * A list of reasons why YouTube may have difficulty transcoding the uploaded video or that might
     * result in an erroneous transcoding. These warnings are generated before YouTube actually
     * processes the uploaded video file. In addition, they identify issues that are unlikely to cause
     * the video processing to fail but that might cause problems such as sync issues, video
     * artifacts, or a missing audio track.
     * The value may be `null`.
     */
    val processingWarnings: List<String>? = null,
    /**
     * A list of keyword tags that could be added to the video's metadata to increase the likelihood
     * that users will locate your video when searching or browsing on YouTube.
     * The value may be `null`.
     */
    val tagSuggestions: List<VideoSuggestionsTagSuggestion>? = null
)
