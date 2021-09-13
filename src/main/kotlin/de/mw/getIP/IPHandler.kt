package de.mw.getIP

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.util.Date
import javax.servlet.http.HttpServletRequest

@RestController
class IPHandler {
    private val logger = KotlinLogging.logger { }

    @GetMapping("/ip")
    @ResponseStatus(HttpStatus.OK)
    fun returnIP(request: HttpServletRequest) {
        logger.info { "Endpoint /ip was called " }
        logger.info { request.remoteHost }
        logger.info { request.remoteAddr }
        logger.info { request.remotePort }
        logger.info { request.getHeader("user-agent") }
        logger.info { Date(request.session.lastAccessedTime) }
        logger.info { request.session.lastAccessedTime }
        return
    }

    @GetMapping("/photo/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun logAccess(request: HttpServletRequest, @PathVariable("id") id: String): String {
        val logData = """
            ###
            Path ID: $id
            Remote host: ${request.remoteHost}
            Remote address: ${request.remoteAddr}
            Remote port: ${request.remotePort}
            Remote user-agent: ${request.getHeader("user-agent")}
            Date formatted: ${Date(request.session.lastAccessedTime)}
            Date raw: ${request.session.lastAccessedTime}
            ###
        """.trimIndent()

        logger.info { "Endpoint /ip was called" }
        logger.info { logData }
        val logFile = File("clickers.log")
        logFile.createNewFile()
        logFile.appendText(logData)

        return "Error file not"
    }
}
