package ru.runx.lempact.external

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class RunProgramServiceImpl : RunProgramService {

    private val logger = LoggerFactory.getLogger(RunProgramServiceImpl::class.java)

    override fun runProgram(args: List<String>, throwErrorOnError: Boolean) {
        val process = ProcessBuilder(args).start()
        val thread = Thread {
            try {
                process.inputReader().use { reader ->
                    reader.lines().forEach {
                        logger.info("args: {}: {}", args.joinToString(" "), it)
                    }
                    val exitCode = process.waitFor()
                    if (exitCode != 0)
                        logger.error("Error code: {}, args: {}", exitCode, args.joinToString(" "))
                    else
                        logger.info("Success run args: {}", args.joinToString(" "))
                }
            } catch (e: Exception) {
                logger.error("Error in second thread", e)
            }
        }
        thread.start()

        process.errorReader().use { reader ->
            reader.lines().forEach {
                if (throwErrorOnError)
                    throw RuntimeException("Error in run app ${args.joinToString(" ")}: $it")
                else
                    logger.error("args: {}: {}", args.joinToString(" "), it)
            }
        }

        thread.join()
    }
}
