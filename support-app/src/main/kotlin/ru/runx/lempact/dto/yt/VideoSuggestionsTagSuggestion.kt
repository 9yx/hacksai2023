package ru.runx.lempact.dto.yt

/**
 * A single tag suggestion with it's relevance information.
 */
data class VideoSuggestionsTagSuggestion(
    /**
     * A set of video categories for which the tag is relevant. You can use this information to
     * display appropriate tag suggestions based on the video category that the video uploader
     * associates with the video. By default, tag suggestions are relevant for all categories if there
     * are no restricts defined for the keyword.
     * The value may be `null`.
     */
    val categoryRestricts: List<String>? = null,
    /**
     * The keyword tag suggested for the video.
     * The value may be `null`.
     */
    val tag: String? = null
)
