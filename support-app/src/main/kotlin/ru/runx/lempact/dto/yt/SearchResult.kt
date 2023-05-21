package ru.runx.lempact.dto.yt

/**
 * A search result contains information about a YouTube video, channel,
 * or playlist that matches the search parameters specified in an API request.
 * While a search result points to a uniquely identifiable resource, like a video,
 * it does not have its own persistent data.
 */
data class SearchResult(
    /**
     * Etag of this resource.
     * The value may be `null`.
     */
    val etag: String? = null,
    /**
     * The id object contains information that can be used to uniquely identify the resource that
     * matches the search request.
     * The value may be `null`.
     */
    val id: ResourceId? = null,
    /**
     * Identifies what kind of resource this is. Value: the fixed string "youtube#searchResult".
     * The value may be `null`.
     */
    val kind: String? = null,
    /**
     * The snippet object contains basic details about a search result, such as its title or
     * description. For example, if the search result is a video, then the title will be the video's
     * title and the description will be the video's description.
     * The value may be `null`.
     */
    val snippet: SearchResultSnippet? = null,
)
