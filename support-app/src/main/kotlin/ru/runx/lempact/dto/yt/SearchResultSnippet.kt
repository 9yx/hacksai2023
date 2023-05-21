package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * Basic details about a search result, including title, description and thumbnails of the item referenced by the search result.
 */
data class SearchResultSnippet(
    /**
     * The value that YouTube uses to uniquely identify the channel that published the resource that
     * the search result identifies.
     * The value may be `null`.
     */
    val channelId: String? = null,
    /**
     * The title of the channel that published the resource that the search result identifies.
     * The value may be `null`.
     */
    val channelTitle: String? = null,
    /**
     * A description of the search result.
     * The value may be `null`.
     */
    val description: String? = null,
    /**
     * It indicates if the resource (video or channel) has upcoming/active live broadcast content. Or
     * it's "none" if there is not any upcoming/active live broadcasts.
     * The value may be `null`.
     */
    val liveBroadcastContent: String? = null,
    /**
     * The creation date and time of the resource that the search result identifies.
     * The value may be `null`.
     */
    val publishedAt: DateTime? = null,
    /**
     * A map of thumbnail images associated with the search result. For each object in the map, the
     * key is the name of the thumbnail image, and the value is an object that contains other
     * information about the thumbnail.
     * The value may be `null`.
     */
    val thumbnails: ThumbnailDetails? = null,
    /**
     * The title of the search result.
     * The value may be `null`.
     */
    val title: String? = null
)
