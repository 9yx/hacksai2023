package ru.runx.lempact.dto.yt

import com.google.api.client.util.DateTime

/**
 * Basic details about a channel, including title, description and thumbnails.
 */
data class ChannelSnippet(
    /**
     * The country of the channel.
     * The value may be `null`.
     */
    val country: String? = null,
    /**
     * The custom url of the channel.
     * The value may be `null`.
     */
    val customUrl: String? = null,
    /**
     * The language of the channel's default title and description.
     * The value may be `null`.
     */
    val defaultLanguage: String? = null,
    /**
     * The description of the channel.
     * The value may be `null`.
     */
    val description: String? = null,
    /**
     * Localized title and description, read-only.
     * The value may be `null`.
     */
    val localized: ChannelLocalization? = null,
    /**
     * The date and time that the channel was created.
     * The value may be `null`.
     */
    val publishedAt: DateTime? = null,
    /**
     * A map of thumbnail images associated with the channel. For each object in the map, the key is
     * the name of the thumbnail image, and the value is an object that contains other information
     * about the thumbnail. When displaying thumbnails in your application, make sure that your code
     * uses the image URLs exactly as they are returned in API responses. For example, your
     * application should not use the http domain instead of the https domain in a URL returned in an
     * API response. Beginning in July 2018, channel thumbnail URLs will only be available in the
     * https domain, which is how the URLs appear in API responses. After that time, you might see
     * broken images in your application if it tries to load YouTube images from the http domain.
     * Thumbnail images might be empty for newly created channels and might take up to one day to
     * populate.
     * The value may be `null`.
     */
    val thumbnails: ThumbnailDetails? = null,
    /**
     * The channel's title.
     * The value may be `null`.
     */
    val title: String? = null
)
