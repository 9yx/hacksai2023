package ru.runx.lempact.dto.yt

import java.math.BigInteger

/**
 * Describes original video file properties, including technical details about audio
 * and video streams, but also metadata information like content length,
 * digitization time, or geotagging information.
 */
data class VideoFileDetails(
    /**
     * A list of audio streams contained in the uploaded video file. Each item in the list contains
     * detailed metadata about an audio stream.
     * The value may be `null`.
     */
    val audioStreams: List<VideoFileDetailsAudioStream?>? = null,
    /**
     * The uploaded video file's combined (video and audio) bitrate in bits per second.
     * The value may be `null`.
     */
    val bitrateBps: BigInteger? = null,
    /**
     * The uploaded video file's container format.
     * The value may be `null`.
     */
    val container: String? = null,
    /**
     * The date and time when the uploaded video file was created. The value is specified in ISO 8601
     * format. Currently, the following ISO 8601 formats are supported: - Date only: YYYY-MM-DD -
     * Naive time: YYYY-MM-DDTHH:MM:SS - Time with timezone: YYYY-MM-DDTHH:MM:SS+HH:MM
     * The value may be `null`.
     */
    val creationTime: String? = null,
    /**
     * The length of the uploaded video in milliseconds.
     * The value may be `null`.
     */
    val durationMs: BigInteger? = null,
    /**
     * The uploaded file's name. This field is present whether a video file or another type of file
     * was uploaded.
     * The value may be `null`.
     */
    val fileName: String? = null,
    /**
     * The uploaded file's size in bytes. This field is present whether a video file or another type
     * of file was uploaded.
     * The value may be `null`.
     */
    val fileSize: BigInteger? = null,
    /**
     * The uploaded file's type as detected by YouTube's video processing engine. Currently, YouTube
     * only processes video files, but this field is present whether a video file or another type of
     * file was uploaded.
     * The value may be `null`.
     */
    val fileType: String? = null,
    /**
     * A list of video streams contained in the uploaded video file. Each item in the list contains
     * detailed metadata about a video stream.
     * The value may be `null`.
     */
    val videoStreams: List<VideoFileDetailsVideoStream>? = null
)
