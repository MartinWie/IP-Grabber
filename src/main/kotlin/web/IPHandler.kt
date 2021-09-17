package de.mw.getIP.web

import de.mw.getIP.services.DiskDataService
import de.mw.getIP.services.IPService
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.* // ktlint-disable no-wildcard-imports
import javax.servlet.http.HttpServletRequest

@RestController
class IPHandler(
    val ipService: IPService,
    val diskDataService: DiskDataService
) {
    companion object : KLogging()

    @GetMapping("/ip/")
    @ResponseStatus(HttpStatus.OK)
    fun returnIP(request: HttpServletRequest): String {
        IPHandler.logger.info { "Endpoint /ip was called " }
        return ipService.getCallerIP(request)
    }

    @GetMapping("/photo/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun logAccess(request: HttpServletRequest, @PathVariable("id") id: String) {
        logger.info { "Endpoint /photo/$id was called" }
        val accessData = ipService.getCallerAccessData(request, id)
        logger.info { "Got this access data: $accessData" }
        diskDataService.save("clickers.log", accessData)
    }
}
