package ru.runx.lempact.external

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.nio.file.Path
import java.nio.file.Paths

@Service
class PredictServiceImpl(
    private val runProgramService: RunProgramService
) : PredictService {

    private val logger = LoggerFactory.getLogger(PredictServiceImpl::class.java)

    override fun predictDirectory(path: Path, project: String, name: String): Path {
        logger.info("Start predict path: {}, project: {}, name: {}", path, project, name)
        val args = listOf(
            "/home/runx/.local/bin/yolo", "predict", "model=yolov8x.pt",
            "source=$path", "save=True", "save_txt=True", "project=$project",
            "name=$name", "conf=0.5", "classes=14"
        )
        runProgramService.runProgram(args)
        logger.info("End predict path: {}, project: {}, name: {}", path, project, name)
        return Paths.get("./$project").toAbsolutePath()
    }
}
