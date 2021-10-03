package de.mw.getIP.services

import mu.KLogging
import org.springframework.stereotype.Service
import java.util.Date
import javax.servlet.http.HttpServletRequest

@Service
class IPService {
    companion object : KLogging()

    fun getCallerIP(request: HttpServletRequest) = request.remoteAddr

    fun getCallerAccessData(request: HttpServletRequest, id: String): String {
        val ipData = IPData(
            id = id,
            hostName = request.remoteHost,
            address = request.remoteAddr,
            port = "${request.remotePort}",
            userAgent = request.getHeader("user-agent"),
            dateFormatted = Date(request.session.lastAccessedTime),
            dateRaw = request.session.lastAccessedTime
        )

        return ipData.toString()
    }
}

data class IPData(
    val id: String,
    val hostName: String,
    val address: String,
    val port: String,
    val userAgent: String,
    val dateFormatted: Date,
    val dateRaw: Long
) {
    override fun toString(): String {
        return """
            ###
            Path ID: $id
            Remote host: $hostName
            Remote address: $address
            Remote port: $port
            Remote user-agent: $userAgent
            Date formatted: $dateFormatted
            Date raw: $dateRaw
            ###
        """.trimIndent()
    }
}
