package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Video processing progress and completion time estimate.
 */
data class VideoProcessingDetailsProcessingProgress(
    /**
     * The number of parts of the video that YouTube has already processed. You can estimate the
     * percentage of the video that YouTube has already processed by calculating: 100 *
     * parts_processed / parts_total Note that since the estimated number of parts could increase
     * without a corresponding increase in the number of parts that have already been processed, it is
     * possible that the calculated progress could periodically decrease while YouTube processes a
     * video.
     * The value may be `null`.
     */
    val partsProcessed: BigInteger? = null,
    /**
     * An estimate of the total number of parts that need to be processed for the video. The number
     * may be updated with more precise estimates while YouTube processes the video.
     * The value may be `null`.
     */
    val partsTotal: BigInteger? = null,
    /**
     * An estimate of the amount of time, in millseconds, that YouTube needs to finish processing the
     * video.
     * The value may be `null`.
     */
    val timeLeftMs: BigInteger? = null,
)
