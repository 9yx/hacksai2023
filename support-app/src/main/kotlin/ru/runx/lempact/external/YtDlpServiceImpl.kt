package ru.runx.lempact.external

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.runx.lempact.config.LempactProperties
import ru.runx.lempact.exception.yt.YtException
import java.nio.file.Path
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.name
import kotlin.io.path.walk

@Service
class YtDlpServiceImpl(
    private val runProgramService: RunProgramService,
    private val lempactProperties: LempactProperties
) : YtDlpService {

    private val logger = LoggerFactory.getLogger(YtDlpServiceImpl::class.java)

    @OptIn(ExperimentalPathApi::class)
    override fun downloadVideo(videoId: String): Path {
        val videoUrl = "https://www.youtube.com/watch?v=$videoId"
        val path = lempactProperties.downloadYtDirectoryPath.resolve(videoId)
        logger.info("Start download video {} to {}", videoUrl, path)
        val args = listOf(
            "yt-dlp",
            "-o", path.toAbsolutePath().toString(),
            videoUrl
        )
        runProgramService.runProgram(
            args = args,
            throwErrorOnError = true
        )
        logger.info("End download video {} to {}", videoUrl, path)
        val foundFile = lempactProperties.downloadYtDirectoryPath
            .walk()
            .map { it.toAbsolutePath() }
            .firstOrNull {
                it.name == "$videoId.mkv" || it.name == "$videoId.webm"
            }
        return foundFile ?: throw YtException("Error download file $videoUrl")
    }
}
