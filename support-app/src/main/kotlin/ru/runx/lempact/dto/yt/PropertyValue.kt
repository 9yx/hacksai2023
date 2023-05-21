package ru.runx.lempact.dto.yt

/**
 * A pair Property / Value.
 */
data class PropertyValue(
    /**
     * A property.
     * The value may be `null`.
     */
    val property: String? = null,

    /**
     * The property's value.
     * The value may be `null`.
     */
    val value: String? = null
)
