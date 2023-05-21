package ru.runx.lempact.dto.dataset

data class CreateDatasetDto(
    val videos: List<Video>

)

data class Video(
    val videoId: String,
    val tags: List<String>,
    val fps: String = "1/60"
)
