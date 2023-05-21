package ru.runx.lempact.service.yt

import ru.runx.lempact.dto.dataset.SplitDatasetDto
import ru.runx.lempact.dto.dataset.Video

interface DatasetService {

    fun splitDataset(dto: SplitDatasetDto)

    fun createDataSet(videos: List<Video>)
}
