package ru.runx.lempact.dto.yt

/**
 * Model definition for ChannelListResponse.
 */
data class ChannelListResponse(
    /**
     * Etag of this resource.
     * The value may be `null`.
     */
    val etag: String? = null,
    /**
     * Serialized EventId of the request which produced this response.
     * The value may be `null`.
     */
    val eventId: String? = null,
    /**
     * The value may be `null`.
     */
    val items: List<Channel>? = null,
    /**
     * Identifies what kind of resource this is. Value: the fixed string
     * "youtube#channelListResponse".
     * The value may be `null`.
     */
    val kind: String? = null,
    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the next page in
     * the result set.
     * The value may be `null`.
     */
    val nextPageToken: String? = null,
    /**
     * General pagination information.
     * The value may be `null`.
     */
    val pageInfo: PageInfo? = null,
    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the previous
     * page in the result set.
     * The value may be `null`.
     */
    val prevPageToken: String? = null,
    /**
     * The value may be `null`.
     */
    val tokenPagination: TokenPagination? = null,
    /**
     * The visitorId identifies the visitor.
     * The value may be `null`.
     */
    val visitorId: String? = null
)
