package ru.runx.lempact.tools

import java.io.InputStream
import java.io.OutputStream

class NotClosableStream(val ins: InputStream) : InputStream() {

    override fun close() {
        // Do nothing
    }

    override fun read(): Int {
        return ins.read()
    }

    override fun read(b: ByteArray): Int {
        return ins.read(b)
    }

    override fun read(b: ByteArray, off: Int, len: Int): Int {
        return ins.read(b, off, len)
    }

    override fun readAllBytes(): ByteArray {
        return ins.readAllBytes()
    }

    override fun readNBytes(len: Int): ByteArray {
        return ins.readNBytes(len)
    }

    override fun readNBytes(b: ByteArray?, off: Int, len: Int): Int {
        return ins.readNBytes(b, off, len)
    }

    override fun skip(n: Long): Long {
        return ins.skip(n)
    }

    override fun skipNBytes(n: Long) {
        ins.skipNBytes(n)
    }

    override fun available(): Int {
        return ins.available()
    }

    override fun mark(readlimit: Int) {
        ins.mark(readlimit)
    }

    override fun reset() {
        ins.reset()
    }

    override fun markSupported(): Boolean {
        return ins.markSupported()
    }

    override fun transferTo(out: OutputStream?): Long {
        return ins.transferTo(out)
    }
}
