package ru.runx.lempact.service.yt

import org.springframework.stereotype.Service
import ru.runx.lempact.dto.dataset.SplitDatasetDto
import ru.runx.lempact.dto.dataset.Video
import ru.runx.lempact.dto.dataset.VideoWithPath
import ru.runx.lempact.external.FfmpegService
import ru.runx.lempact.external.PredictService
import ru.runx.lempact.external.YtDlpService
import java.nio.file.Path
import java.nio.file.Paths
import java.time.Instant
import java.util.*
import kotlin.io.path.*

@Service
class DatasetServiceImpl(
    private val ytDlpService: YtDlpService,
    private val ffmpegService: FfmpegService,
    private val predictService: PredictService
) : DatasetService {

    override fun splitDataset(dto: SplitDatasetDto) {
        dto.dirs.forEach { folder ->
            createDataset(
                projectDir = folder.dir,
                imagesDir = folder.dir.resolve("images"),
                predictDirectory = folder.dir.resolve("123/predict/labels"),
                map = emptyList(),
                forceTag = folder.tag
            )
        }
    }

    override fun createDataSet(videos: List<Video>) {
        val map = videos.map {
            it.videoId to it.tags
        }

        val projectName = UUID.randomUUID().toString()
        val resultDirectory = "photos-${Instant.now().epochSecond}"
        val downloaded = videos.map { video ->
            VideoWithPath(
                video = video,
                path = ytDlpService.downloadVideo(video.videoId)
            )
        }
        var videoPath: Path? = null
        downloaded.forEach { videoWithPath ->
            videoPath = videoWithPath.path
            ffmpegService.breakIntoImages(
                videoPath = videoWithPath.path,
                resultDirectory = resultDirectory,
                fps = videoWithPath.video.fps
            )
        }

        val imagesDir = videoPath!!.parent.resolve(resultDirectory)
        val predictDirectory = predictService.predictDirectory(imagesDir, projectName, "predict")
            .resolve("predict/labels").toAbsolutePath()

        val projectDir = Paths.get(projectName).toAbsolutePath()
        createDataset(projectDir, imagesDir, predictDirectory, map)
    }

    companion object {
        private val regex14 = Regex("^14")
    }

    @OptIn(ExperimentalPathApi::class)
    private fun createDataset(
        projectDir: Path,
        imagesDir: Path,
        predictDirectory: Path,
        map: List<Pair<String, List<String>>>,
        forceTag: String? = null
    ) {
        val trainImagesDir = projectDir.resolve("train/images").toAbsolutePath()
        trainImagesDir.createDirectories()
        val trainLabelsDir = projectDir.resolve("train/labels").toAbsolutePath()
        trainLabelsDir.createDirectories()

        val valImagesDir = projectDir.resolve("valid/images").toAbsolutePath()
        valImagesDir.createDirectories()
        val valLabelsDir = projectDir.resolve("valid/labels").toAbsolutePath()
        valLabelsDir.createDirectories()

        imagesDir.walk().sorted().forEachIndexed { index, image ->
            val txtFile = predictDirectory.resolve(image.nameWithoutExtension + ".txt")
            if (index % 2 == 0) {
                createFiles(image, valImagesDir, txtFile, valLabelsDir, map, forceTag)
            } else {
                createFiles(image, trainImagesDir, txtFile, trainLabelsDir, map, forceTag)
            }
        }
    }

    private fun createFiles(
        image: Path,
        imagesDir: Path,
        txtFile: Path,
        labelsDir: Path,
        map: List<Pair<String, List<String>>>,
        forceTag: String? = null
    ) {
        image.copyTo(imagesDir.resolve(image.name))
        if (txtFile.exists()) {
            val newTxtFile = labelsDir.resolve(txtFile.name)

            val newTag = forceTag
                ?: (map.firstOrNull {
                    newTxtFile.name.startsWith(it.first)
                })!!.second.first()

            newTxtFile.bufferedWriter().use { writer ->
                txtFile.bufferedReader().use {
                    it.lines().forEach { line ->
                        writer.write(line.replace(regex14, newTag))
                        writer.newLine()
                    }
                }
            }
        }
    }
}
