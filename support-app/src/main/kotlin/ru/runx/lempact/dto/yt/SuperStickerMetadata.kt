package ru.runx.lempact.dto.yt

/**
 * Model definition for SuperStickerMetadata.
 */
data class SuperStickerMetadata(
    /**
     * Internationalized alt text that describes the sticker image and any animation associated with
     * it.
     * The value may be `null`.
     */
    val altText: String? = null,
    /**
     * Specifies the localization language in which the alt text is returned.
     * The value may be `null`.
     */
    val altTextLanguage: String? = null,
    /**
     * Unique identifier of the Super Sticker. This is a shorter form of the alt_text that includes
     * pack name and a recognizable characteristic of the sticker.
     * The value may be `null`.
     */
    val stickerId: String? = null
)
