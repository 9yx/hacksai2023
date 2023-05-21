package ru.runx.lempact.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import ru.runx.lempact.dto.dataset.CheckModelDto
import ru.runx.lempact.dto.dataset.CreateDatasetDto
import ru.runx.lempact.dto.dataset.SplitDatasetDto
import ru.runx.lempact.service.yt.DatasetService
import ru.runx.lempact.service.yt.ValidateService

@RestController
@RequestMapping("/api/v1")
class DatasetController(
    private val validateService: ValidateService,
    private val datasetService: DatasetService
) {

    @PostMapping(
        value = ["/dataset/checkModel"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun checkModel(
        @RequestBody request: CheckModelDto
    ): Mono<String> {
        return Mono.fromCallable {
            validateService.score(request)
            "success"
        }.subscribeOn(Schedulers.boundedElastic())
    }

    @PostMapping(
        value = ["/dataset/splitDirectory"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun splitDirectory(
        @RequestBody request: SplitDatasetDto
    ): Mono<String> {
        return Mono.fromCallable {
            datasetService.splitDataset(request)
            "success"
        }.subscribeOn(Schedulers.boundedElastic())
    }

    @PostMapping(
        value = ["/dataset/create"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createDataset(
        @RequestBody request: CreateDatasetDto
    ): Mono<String> {
        return Mono.fromCallable {
            datasetService.createDataSet(videos = request.videos)
            "success"
        }.subscribeOn(Schedulers.boundedElastic())
    }
}
