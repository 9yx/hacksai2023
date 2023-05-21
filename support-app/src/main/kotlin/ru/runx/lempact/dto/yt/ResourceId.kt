package ru.runx.lempact.dto.yt

/**
 * A resource id is a generic reference that points to another YouTube resource.
 */
data class ResourceId(
    /**
     * The ID that YouTube uses to uniquely identify the referred resource, if that resource is a
     * channel. This property is only present if the resourceId.kind value is youtube#channel.
     * The value may be `null`.
     */
    val channelId: String? = null,
    /**
     * The type of the API resource.
     * The value may be `null`.
     */
    val kind: String? = null,
    /**
     * The ID that YouTube uses to uniquely identify the referred resource, if that resource is a
     * playlist. This property is only present if the resourceId.kind value is youtube#playlist.
     * The value may be `null`.
     */
    val playlistId: String? = null,
    /**
     * The ID that YouTube uses to uniquely identify the referred resource, if that resource is a
     * video. This property is only present if the resourceId.kind value is youtube#video.
     * The value may be `null`.
     */
    val videoId: String? = null
)
