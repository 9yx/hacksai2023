package ru.runx.lempact.dto.yt

/**
 * DEPRECATED. b/157517979: This part was never populated after it was added. However, it sees non- zero traffic
 * because there is generated client code in the wild that refers to it [1]. We keep this field and
 * do NOT remove it because otherwise V3 would return an error when this part gets requested [2].
 * [1] https://developers.google.com/resources/api-libraries/documentation/youtube/v3/csharp/latest/
 * classGoogle_1_1Apis_1_1YouTube_1_1v3_1_1Data_1_1VideoProjectDetails.html
 * [2] http://google3/video/youtube/src/python/servers/data_api/common.py?l=1565-1569=344141677
 */
@Deprecated("DEPRECATED. b/157517979: This part was never populated after it was added.")
class VideoProjectDetails: HashMap<String, Any>()
