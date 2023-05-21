package ru.runx.lempact.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import java.nio.file.Path

@ConfigurationProperties(prefix = "app.lempact", ignoreUnknownFields = false)
data class LempactProperties @ConstructorBinding constructor(
    val downloadYtDirectoryPath: Path
)
