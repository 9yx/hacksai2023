package ru.runx.lempact.tools

import org.springframework.core.io.InputStreamResource
import java.io.InputStream


class InputStreamCustomResource(inputStream: InputStream, private val fileName: String) :
    InputStreamResource(inputStream) {

    override fun contentLength(): Long {
        return -1
    }

    override fun getFilename(): String {
        return this.fileName
    }
}
