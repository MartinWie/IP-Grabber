package de.mw.getIP.services

import mu.KLogging
import org.springframework.stereotype.Service
import java.util.Date
import javax.servlet.http.HttpServletRequest

@Service
class IPService {
    companion object : KLogging()

    fun getCallerIP(request: HttpServletRequest): String {
        // IPHandler.logger.info { request.remoteHost }
        // IPHandler.logger.info { request.remoteAddr }
        // IPHandler.logger.info { request.remotePort }
        // IPHandler.logger.info { request.getHeader("user-agent") }
        // IPHandler.logger.info { Date(request.session.lastAccessedTime) }
        // IPHandler.logger.info { request.session.lastAccessedTime }
        return request.remoteAddr
    }

    fun getCallerAccessData(request: HttpServletRequest, id: String): String {
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

        return logData
    }
}
