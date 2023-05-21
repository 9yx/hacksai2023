package ru.runx.lempact.dto.yt

/**
 * Model definition for LocalizedProperty.
 */
data class LocalizedProperty(
    /**
     * The value may be `null`.
     */
    val default: String? = null,

    /**
     * The language of the default property.
     * The value may be `null`.
     */
    val defaultLanguage: LanguageTag? = null,

    /**
     * The value may be `null`.
     */
    val localized: List<LocalizedString>? = null
)
