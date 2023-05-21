package ru.runx.lempact.dto.yt

/**
 * Model definition for LiveChatGiftMembershipReceivedDetails.
 */
data class LiveChatGiftMembershipReceivedDetails(
    /**
     * The ID of the membership gifting message that is related to this gift membership. This ID will
     * always refer to a message whose type is 'membershipGiftingEvent'.
     * The value may be `null`.
     */
    val associatedMembershipGiftingMessageId: String? = null,
    /**
     * The ID of the user that made the membership gifting purchase. This matches the
     * `snippet.authorChannelId` of the associated membership gifting message.
     * The value may be `null`.
     */
    val gifterChannelId: String? = null,
    /**
     * The name of the Level at which the viewer is a member. This matches the
     * `snippet.membershipGiftingDetails.giftMembershipsLevelName` of the associated membership
     * gifting message. The Level names are defined by the YouTube channel offering the Membership. In
     * some situations this field isn't filled.
     * The value may be `null`.
     */
    val memberLevelName: String? = null
)
