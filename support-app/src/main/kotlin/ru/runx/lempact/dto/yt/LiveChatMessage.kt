package ru.runx.lempact.dto.yt

/**
 * A *liveChatMessage* resource represents a chat message in a YouTube Live Chat.
 */
data class LiveChatMessage(
    /**
     * The authorDetails object contains basic details about the user that posted this message.
     * The value may be `null`.
     */
    val authorDetails: LiveChatMessageAuthorDetails? = null,
    /**
     * Etag of this resource.
     * The value may be `null`.
     */
    val etag: String? = null,
    /**
     * The ID that YouTube assigns to uniquely identify the message.
     * The value may be `null`.
     */
    val id: String? = null,
    /**
     * Identifies what kind of resource this is. Value: the fixed string "youtube#liveChatMessage".
     * The value may be `null`.
     */
    val kind: String? = null,

    /**
     * The snippet object contains basic details about the message.
     * The value may be `null`.
     */
    val snippet: LiveChatMessageSnippet? = null,
)
