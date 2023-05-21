package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * The contentOwnerDetails object encapsulates channel data that is relevant for YouTube Partners linked with the channel.
 */
data class ChannelContentOwnerDetails(
    /**
     * The ID of the content owner linked to the channel.
     * The value may be `null`.
     */
    var contentOwner: String? = null,
    /**
     * The date and time when the channel was linked to the content owner.
     * The value may be `null`.
     */
    val timeLinked: DateTime? = null
)
