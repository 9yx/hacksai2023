package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Model definition for LiveChatFanFundingEventDetails.
 */
data class LiveChatFanFundingEventDetails(
    /**
     * A rendered string that displays the fund amount and currency to the user.
     * The value may be `null`.
     */
    val amountDisplayString: String? = null,
    /**
     * The amount of the fund.
     * The value may be `null`.
     */
    val amountMicros: BigInteger? = null,
    /**
     * The currency in which the fund was made.
     * The value may be `null`.
     */
    val currency: String? = null,
    /**
     * The comment added by the user to this fan funding event.
     * The value may be `null`.
     */
    val userComment: String? = null
)
