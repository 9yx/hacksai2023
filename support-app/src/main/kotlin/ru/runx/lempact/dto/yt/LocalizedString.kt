package ru.runx.lempact.dto.yt

/**
 * Model definition for LocalizedString.
 */
data class LocalizedString(
    /**
     * The value may be `null`.
     */
    val language: String? = null,
    /**
     * The value may be `null`.
     */
    val value: String? = null
)
