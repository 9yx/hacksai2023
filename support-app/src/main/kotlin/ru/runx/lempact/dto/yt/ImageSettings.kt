package ru.runx.lempact.dto.yt

/**
 * Branding properties for images associated with the channel.
 */
data class ImageSettings(
    /**
     * The URL for the background image shown on the video watch page. The image should be 1200px by
     * 615px, with a maximum file size of 128k.
     * The value may be `null`.
     */
    val backgroundImageUrl: LocalizedProperty? = null,
    /**
     * This is generated when a ChannelBanner.Insert request has succeeded for the given channel.
     * The value may be `null`.
     */
    val bannerExternalUrl: String? = null,
    /**
     * Banner image. Desktop size (1060x175).
     * The value may be `null`.
     */
    val bannerImageUrl: String? = null,
    /**
     * Banner image. Mobile size high resolution (1440x395).
     * The value may be `null`.
     */
    val bannerMobileExtraHdImageUrl: String? = null,
    /**
     * Banner image. Mobile size high resolution (1280x360).
     * The value may be `null`.
     */
    val bannerMobileHdImageUrl: String? = null,
    /**
     * Banner image. Mobile size (640x175).
     * The value may be `null`.
     */
    val bannerMobileImageUrl: String? = null,
    /**
     * Banner image. Mobile size low resolution (320x88).
     * The value may be `null`.
     */
    val bannerMobileLowImageUrl: String? = null,
    /**
     * Banner image. Mobile size medium/high resolution (960x263).
     * The value may be `null`.
     */
    val bannerMobileMediumHdImageUrl: String? = null,
    /**
     * Banner image. Tablet size extra high resolution (2560x424).
     * The value may be `null`.
     */
    val bannerTabletExtraHdImageUrl: String? = null,
    /**
     * Banner image. Tablet size high resolution (2276x377).
     * The value may be `null`.
     */
    val bannerTabletHdImageUrl: String? = null,
    /**
     * Banner image. Tablet size (1707x283).
     * The value may be `null`.
     */
    val bannerTabletImageUrl: String? = null,
    /**
     * Banner image. Tablet size low resolution (1138x188).
     * The value may be `null`.
     */
    val bannerTabletLowImageUrl: String? = null,
    /**
     * Banner image. TV size high resolution (1920x1080).
     * The value may be `null`.
     */
    val bannerTvHighImageUrl: String? = null,
    /**
     * Banner image. TV size extra high resolution (2120x1192).
     * The value may be `null`.
     */
    val bannerTvImageUrl: String? = null,
    /**
     * Banner image. TV size low resolution (854x480).
     * The value may be `null`.
     */
    val bannerTvLowImageUrl: String? = null,
    /**
     * Banner image. TV size medium resolution (1280x720).
     * The value may be `null`.
     */
    val bannerTvMediumImageUrl: String? = null,
    /**
     * The image map script for the large banner image.
     * The value may be `null`.
     */
    val largeBrandedBannerImageImapScript: LocalizedProperty? = null,
    /**
     * The URL for the 854px by 70px image that appears below the video player in the expanded video
     * view of the video watch page.
     * The value may be `null`.
     */
    val largeBrandedBannerImageUrl: LocalizedProperty? = null,
    /**
     * The image map script for the small banner image.
     * The value may be `null`.
     */
    val smallBrandedBannerImageImapScript: LocalizedProperty? = null,
    /**
     * The URL for the 640px by 70px banner image that appears below the video player in the default
     * view of the video watch page. The URL for the image that appears above the top-left corner of
     * the video player. This is a 25-pixel-high image with a flexible width that cannot exceed 170
     * pixels.
     * The value may be `null`.
     */
    val smallBrandedBannerImageUrl: LocalizedProperty? = null,
    /**
     * The URL for a 1px by 1px tracking pixel that can be used to collect statistics for views of the
     * channel or video pages.
     * The value may be `null`.
     */
    val trackingImageUrl: String? = null,
    /**
     * The value may be `null`.
     */
    val watchIconImageUrl: String? = null
)
