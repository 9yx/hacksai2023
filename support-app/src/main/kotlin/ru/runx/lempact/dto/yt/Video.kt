package ru.runx.lempact.dto.yt

/**
 * A *video* resource represents a YouTube video.
 */
data class Video(
    /**
     * Age restriction details related to a video. This data can only be retrieved by the video owner.
     * The value may be `null`.
     */
    val ageGating: VideoAgeGating? = null,
    /**
     * The contentDetails object contains information about the video content, including the length of
     * the video and its aspect ratio.
     * The value may be `null`.
     */
    val contentDetails: VideoContentDetails? = null,
    /**
     * Etag of this resource.
     * The value may be `null`.
     */
    val etag: String? = null,
    /**
     * The fileDetails object encapsulates information about the video file that was uploaded to
     * YouTube, including the file's resolution, duration, audio and video codecs, stream bitrates,
     * and more. This data can only be retrieved by the video owner.
     * The value may be `null`.
     */
    val fileDetails: VideoFileDetails? = null,
    /**
     * The ID that YouTube uses to uniquely identify the video.
     * The value may be `null`.
     */
    val id: String? = null,
    /**
     * Identifies what kind of resource this is. Value: the fixed string "youtube#video".
     * The value may be `null`.
     */
    val kind: String? = null,
    /**
     * The liveStreamingDetails object contains metadata about a live video broadcast. The object will
     * only be present in a video resource if the video is an upcoming, live, or completed live
     * broadcast.
     * The value may be `null`.
     */
    val liveStreamingDetails: VideoLiveStreamingDetails? = null,
    /**
     * The localizations object contains localized versions of the basic details about the video, such
     * as its title and description.
     * The value may be `null`.
     */
    val localizations: Map<String, VideoLocalization>? = null,
    /**
     * The monetizationDetails object encapsulates information about the monetization status of the
     * video.
     * The value may be `null`.
     */
    val monetizationDetails: VideoMonetizationDetails? = null,
    /**
     * The player object contains information that you would use to play the video in an embedded
     * player.
     * The value may be `null`.
     */
    val player: VideoPlayer? = null,
    /**
     * The processingDetails object encapsulates information about YouTube's progress in processing
     * the uploaded video file. The properties in the object identify the current processing status
     * and an estimate of the time remaining until YouTube finishes processing the video. This part
     * also indicates whether different types of data or content, such as file details or thumbnail
     * images, are available for the video. The processingProgress object is designed to be polled so
     * that the video uploaded can track the progress that YouTube has made in processing the uploaded
     * video file. This data can only be retrieved by the video owner.
     * The value may be `null`.
     */
    val processingDetails: VideoProcessingDetails? = null,
    /**
     * The projectDetails object contains information about the project specific video metadata.
     * b/157517979: This part was never populated after it was added. However, it sees non-zero
     * traffic because there is generated client code in the wild that refers to it [1]. We keep this
     * field and do NOT remove it because otherwise V3 would return an error when this part gets
     * requested [2]. [1] https://developers.google.com/resources/api-libraries/documentation/youtube/
     * v3/csharp/latest/classGoogle_1_1Apis_1_1YouTube_1_1v3_1_1Data_1_1VideoProjectDetails.html [2]
     * http://google3/video/youtube/src/python/servers/data_api/common.py?l=1565-1569=344141677
     * The value may be `null`.
     */
    val projectDetails: VideoProjectDetails? = null,
    /**
     * The recordingDetails object encapsulates information about the location, date and address where
     * the video was recorded.
     * The value may be `null`.
     */
    val recordingDetails: VideoRecordingDetails? = null,
    /**
     * The snippet object contains basic details about the video, such as its title, description, and
     * category.
     * The value may be `null`.
     */
    val snippet: VideoSnippet? = null,
    /**
     * The statistics object contains statistics about the video.
     * The value may be `null`.
     */
    val statistics: VideoStatistics? = null,
    /**
     * The status object contains information about the video's uploading, processing, and privacy
     * statuses.
     * The value may be `null`.
     */
    val status: VideoStatus? = null,
    /**
     * The suggestions object encapsulates suggestions that identify opportunities to improve the
     * video quality or the metadata for the uploaded video. This data can only be retrieved by the
     * video owner.
     * The value may be `null`.
     */
    val suggestions: VideoSuggestions? = null,
    /**
     * The topicDetails object encapsulates information about Freebase topics associated with the
     * video.
     * The value may be `null`.
     */
    val topicDetails: VideoTopicDetails? = null
)
