package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Model definition for LiveChatSuperChatDetails.
 */
data class LiveChatSuperChatDetails(
    /**
     * A rendered string that displays the fund amount and currency to the user.
     * The value may be `null`.
     */
    val amountDisplayString: String? = null,
    /**
     * The amount purchased by the user, in micros (1,750,000 micros = 1.75).
     * The value may be `null`.
     */
    val amountMicros: BigInteger? = null,
    /**
     * The currency in which the purchase was made.
     * The value may be `null`.
     */
    val currency: String? = null,
    /**
     * The tier in which the amount belongs. Lower amounts belong to lower tiers. The lowest tier is
     * 1.
     * The value may be `null`.
     */
    val tier: Long? = null,
    /**
     * The comment added by the user to this Super Chat event.
     * The value may be `null`.
     */
    val userComment: String? = null
)
