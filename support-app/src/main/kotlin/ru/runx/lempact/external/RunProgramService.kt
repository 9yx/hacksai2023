package ru.runx.lempact.external

interface RunProgramService {
    fun runProgram(args: List<String>, throwErrorOnError: Boolean = false)
}
