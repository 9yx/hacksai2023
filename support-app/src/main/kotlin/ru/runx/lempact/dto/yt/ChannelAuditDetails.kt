package ru.runx.lempact.dto.yt

/**
 * The auditDetails object encapsulates channel data that is relevant for YouTube Partners during the audit process.
 */
data class ChannelAuditDetails(
    /**
     * Whether or not the channel respects the community guidelines.
     * The value may be `null`.
     */
    val communityGuidelinesGoodStanding: Boolean? = null,
    /**
     * Whether or not the channel has any unresolved claims.
     * The value may be `null`.
     */
    val contentIdClaimsGoodStanding: Boolean? = null,
    /**
     * Whether or not the channel has any copyright strikes.
     * The value may be `null`.
     */
    val copyrightStrikesGoodStanding: Boolean? = null
)
