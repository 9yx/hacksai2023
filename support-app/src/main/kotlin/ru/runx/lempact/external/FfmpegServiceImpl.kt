package ru.runx.lempact.external

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.nio.file.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.exists
import kotlin.io.path.name

@Service
class FfmpegServiceImpl(
    private val runProgramService: RunProgramService
) : FfmpegService {

    private val logger = LoggerFactory.getLogger(YtDlpServiceImpl::class.java)

    override fun breakIntoImages(videoPath: Path, resultDirectory: String, fps: String) {
        logger.info("Start break into images videoPath {} resultDirectory {} fps {}",
            videoPath, resultDirectory, fps)

        val outputDirectory = videoPath
            .parent
            .resolve(resultDirectory)

        if (!outputDirectory.exists())
            outputDirectory.createDirectory()

        val args = listOf(
            "ffmpeg", "-r", "1", "-i", videoPath.toAbsolutePath().toString(),
            "-filter:v", "fps=fps=$fps", "${outputDirectory.toAbsolutePath()}/${videoPath.name}%010d.jpg",
            "-hide_banner"
        )

        runProgramService.runProgram(args)
        logger.info("End break into images videoPath {} resultDirectory {} fps {}",
            videoPath, resultDirectory, fps)
    }
}
