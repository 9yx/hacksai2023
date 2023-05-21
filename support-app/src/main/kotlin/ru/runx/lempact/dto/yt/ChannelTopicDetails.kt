package ru.runx.lempact.dto.yt

/**
 * Freebase topic information related to the channel.
 */
data class ChannelTopicDetails(
    /**
     * A list of Wikipedia URLs that describe the channel's content.
     * The value may be `null`.
     */
    val topicCategories: List<String?>? = null,
    /**
     * A list of Freebase topic IDs associated with the channel. You can retrieve information about
     * each topic using the Freebase Topic API.
     * The value may be `null`.
     */
    val topicIds: List<String>? = null
)
