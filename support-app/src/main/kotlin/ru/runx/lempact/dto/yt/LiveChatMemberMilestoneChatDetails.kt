package ru.runx.lempact.dto.yt

/**
 * Model definition for LiveChatMemberMilestoneChatDetails.
 */
data class LiveChatMemberMilestoneChatDetails(
    /**
     * The name of the Level at which the viever is a member. The Level names are defined by the
     * YouTube channel offering the Membership. In some situations this field isn't filled.
     * The value may be `null`.
     */
    val memberLevelName: String? = null,
    /**
     * The total amount of months (rounded up) the viewer has been a member that granted them this
     * Member Milestone Chat. This is the same number of months as is being displayed to YouTube
     * users.
     * The value may be `null`.
     */
    val memberMonth: Long? = null,
    /**
     * The comment added by the member to this Member Milestone Chat. This field is empty for messages
     * without a comment from the member.
     * The value may be `null`.
     */
    val userComment: String? = null
)
