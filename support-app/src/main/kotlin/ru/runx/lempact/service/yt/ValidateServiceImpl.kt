package ru.runx.lempact.service.yt

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpEntity
import org.springframework.http.MediaType
import org.springframework.http.client.MultipartBodyBuilder
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.netty.http.client.HttpClient
import ru.runx.lempact.dto.dataset.CheckModelDto
import ru.runx.lempact.tools.InputStreamCustomResource
import ru.runx.lempact.tools.NotClosableStream
import java.io.File
import java.io.InputStream
import java.io.PrintWriter
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.inputStream
import kotlin.io.path.name
import kotlin.io.path.walk

@Service
class ValidateServiceImpl(
    webClientBuilder: WebClient.Builder
) : ValidateService {

    private val webClient: WebClient
    private val logger = LoggerFactory.getLogger(ValidateServiceImpl::class.java)

    init {
        val httpClient = HttpClient.newConnection()
        httpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 20000)
        httpClient.option(ChannelOption.SO_KEEPALIVE, false)
        httpClient.doOnConnected { conn ->
            conn.addHandlerLast(ReadTimeoutHandler(50))
            conn.addHandlerLast(WriteTimeoutHandler(50))
        }

        webClient = webClientBuilder.clientConnector(ReactorClientHttpConnector(httpClient))
            .baseUrl("http://127.0.0.1:8088")
            .build()
    }

    private fun convertToCSV(data: Array<String>): String {
        return data.joinToString(";") {
            escapeSpecialCharacters(it)
        }
    }

    private fun writeCsvFile(fileName: String, data: List<Array<String>>) {
        val csvOutputFile: File = File(fileName)
        PrintWriter(csvOutputFile).use { pw ->
            data.map {
                convertToCSV(it)
            }.forEach {
                pw.println(it)
            }
        }
    }

    private fun escapeSpecialCharacters(data: String): String {
        var data = data
        var escapedData = data.replace("\\R".toRegex(), " ")
        if (data.contains(";") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"")
            escapedData = "\"" + data + "\""
        }
        return escapedData
    }

    private fun fromInputStream(
        inputStream: InputStream, fileName: String, contentType: String
    ): MultiValueMap<String, HttpEntity<*>> {
        val builder = MultipartBodyBuilder()
        builder.part("file", InputStreamCustomResource(inputStream, fileName), MediaType.parseMediaType(contentType))
        return builder.build()
    }

    private fun getFileClass(score: List<Double>): String {
        val pairList = listOf(
            "2" to score[0], // Кликун
            "1" to score[1], // Малый
            "3" to score[2] // Шипун
        )
        val max = pairList.maxBy {
            it.second
        }
        return max.first
    }

    @OptIn(ExperimentalPathApi::class)
    override fun score(request: CheckModelDto) {
        val list = mutableListOf<Array<String>>()
        list.add(arrayOf("name", "class"))

        ClassPathResource("files").inputStream.bufferedReader().use {
            it.lineSequence().forEach { fileName ->
                val path = request.path.resolve(fileName)
                val scoreList: List<Double> = path.inputStream().use { inputStream ->
                    runBlocking {
                        webClient.post().uri { uriBuilder ->
                            uriBuilder.path("/cls").build()
                        }.contentType(MediaType.MULTIPART_FORM_DATA).body(
                            BodyInserters.fromMultipartData(
                                fromInputStream(
                                    NotClosableStream(inputStream), path.name, "application/octet-stream"
                                )
                            )
                        ).accept(MediaType.APPLICATION_JSON).retrieve().awaitBody()
                    }
                }
                list.add(arrayOf(path.name, getFileClass(scoreList)))
                logger.info(
                    "File: {}, Кликун : {}, Малый: {}, Шипун: {}",
                    path.fileName,
                    scoreList[0],
                    scoreList[1],
                    scoreList[2]
                )
            }
        }

        writeCsvFile("/home/runx/submission.csv", list)
    }
}
