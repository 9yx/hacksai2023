package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * Next ID: 33
 */
data class LiveChatMessageSnippet(
    /**
     * The ID of the user that authored this message, this field is not always filled.
     * textMessageEvent - the user that wrote the message fanFundingEvent - the user that funded the
     * broadcast newSponsorEvent - the user that just became a sponsor memberMilestoneChatEvent - the
     * member that sent the message membershipGiftingEvent - the user that made the purchase
     * giftMembershipReceivedEvent - the user that received the gift membership messageDeletedEvent -
     * the moderator that took the action messageRetractedEvent - the author that retracted their
     * message userBannedEvent - the moderator that took the action superChatEvent - the user that
     * made the purchase superStickerEvent - the user that made the purchase
     * The value may be `null`.
     */
    val authorChannelId: String? = null,
    /**
     * Contains a string that can be displayed to the user. If this field is not present the message
     * is silent, at the moment only messages of type TOMBSTONE and CHAT_ENDED_EVENT are silent.
     * The value may be `null`.
     */
    val displayMessage: String? = null,
    /**
     * Details about the funding event, this is only set if the type is 'fanFundingEvent'.
     * The value may be `null`.
     */
    val fanFundingEventDetails: LiveChatFanFundingEventDetails? = null,
    /**
     * Details about the Gift Membership Received event, this is only set if the type is
     * 'giftMembershipReceivedEvent'.
     * The value may be `null`.
     */
    val giftMembershipReceivedDetails: LiveChatGiftMembershipReceivedDetails? = null,
    /**
     * Whether the message has display content that should be displayed to users.
     * The value may be `null`.
     */
    val hasDisplayContent: Boolean? = null,
    /**
     * The value may be `null`.
     */
    val liveChatId: String? = null,
    /**
     * Details about the Member Milestone Chat event, this is only set if the type is
     * 'memberMilestoneChatEvent'.
     * The value may be `null`.
     */
    val memberMilestoneChatDetails: LiveChatMemberMilestoneChatDetails? = null,
    /**
     * Details about the Membership Gifting event, this is only set if the type is
     * 'membershipGiftingEvent'.
     * The value may be `null`.
     */
    val membershipGiftingDetails: LiveChatMembershipGiftingDetails? = null,
    /**
     * The value may be `null`.
     */
    val messageDeletedDetails: LiveChatMessageDeletedDetails? = null,
    /**
     * The value may be `null`.
     */
    val messageRetractedDetails: LiveChatMessageRetractedDetails? = null,
    /**
     * Details about the New Member Announcement event, this is only set if the type is
     * 'newSponsorEvent'. Please note that "member" is the new term for "sponsor".
     * The value may be `null`.
     */
    val newSponsorDetails: LiveChatNewSponsorDetails? = null,
    /**
     * The date and time when the message was orignally published.
     * The value may be `null`.
     */
    val publishedAt: DateTime? = null,
    /**
     * Details about the Super Chat event, this is only set if the type is 'superChatEvent'.
     * The value may be `null`.
     */
    val superChatDetails: LiveChatSuperChatDetails? = null,
    /**
     * Details about the Super Sticker event, this is only set if the type is 'superStickerEvent'.
     * The value may be `null`.
     */
    val superStickerDetails: LiveChatSuperStickerDetails? = null,
    /**
     * Details about the text message, this is only set if the type is 'textMessageEvent'.
     * The value may be `null`.
     */
    val textMessageDetails: LiveChatTextMessageDetails? = null,
    /**
     * The type of message, this will always be present, it determines the contents of the message as
     * well as which fields will be present.
     * The value may be `null`.
     */
    val type: String? = null,
    /**
     * The value may be `null`.
     */
    val userBannedDetails: LiveChatUserBannedMessageDetails? = null
)
