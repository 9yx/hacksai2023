package ru.runx.lempact.dto.yt

/**
 * JSON template for the status part of a channel.
 */
data class ChannelStatus(
    /**
     * If true, then the user is linked to either a YouTube username or G+ account. Otherwise, the
     * user doesn't have a public YouTube identity.
     * The value may be `null`.
     */
    val isLinked: Boolean? = null,
    /**
     * The long uploads status of this channel. See https://support.google.com/youtube/answer/71673
     * for more information.
     * The value may be `null`.
     */
    val longUploadsStatus: String? = null,
    /**
     * The value may be `null`.
     */
    val madeForKids: Boolean? = null,
    /**
     * Privacy status of the channel.
     * The value may be `null`.
     */
    val privacyStatus: String? = null,
    /**
     * The value may be `null`.
     */
    val selfDeclaredMadeForKids: Boolean? = null
)
