package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * Model definition for LiveChatMessageListResponse.
 */
data class LiveChatMessageListResponse(
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
    val items: List<LiveChatMessage>? = null,
    /**
     * Identifies what kind of resource this is. Value: the fixed string
     * "youtube#liveChatMessageListResponse".
     * The value may be `null`.
     */
    val kind: String? = null,
    /**
     * The value may be `null`.
     */
    val nextPageToken: String? = null,
    /**
     * The date and time when the underlying stream went offline.
     * The value may be `null`.
     */
    val offlineAt: DateTime? = null,
    /**
     * General pagination information.
     * The value may be `null`.
     */
    val pageInfo: PageInfo? = null,
    /**
     * The amount of time the client should wait before polling again.
     * The value may be `null`.
     */
    val pollingIntervalMillis: Long? = null,
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
