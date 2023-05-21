package ru.runx.lempact.dto.yt

/**
 * Rights management policy for YouTube resources.
 */
data class AccessPolicy(
    /**
     * The value of allowed indicates whether the access to the policy is allowed or denied by
     * default.
     * The value may be `null`.
     */
    val allowed: Boolean? = null,

    /**
     * A list of region codes that identify countries where the default policy do not apply.
     * The value may be `null`.
     */
    val exception: List<String>? = null
)
