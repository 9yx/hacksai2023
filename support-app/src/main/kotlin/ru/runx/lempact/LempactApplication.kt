package ru.runx.lempact

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class LempactApplication

fun main(args: Array<String>) {
	runApplication<LempactApplication>(*args)
}
