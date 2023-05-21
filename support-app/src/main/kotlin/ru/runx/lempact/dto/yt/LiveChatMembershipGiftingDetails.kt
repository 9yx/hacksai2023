package ru.runx.lempact.dto.yt

/**
 * Model definition for LiveChatMembershipGiftingDetails.
 */
data class LiveChatMembershipGiftingDetails(
    /**
     * The number of gift memberships purchased by the user.
     * The value may be `null`.
     */
    val giftMembershipsCount: Int? = null,
    /**
     * The name of the level of the gift memberships purchased by the user. The Level names are
     * defined by the YouTube channel offering the Membership. In some situations this field isn't
     * filled.
     * The value may be `null`.
     */
    val giftMembershipsLevelName: String? = null
)
