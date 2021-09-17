package de.mw.getIP.services

import de.mw.getIP.data.DataClient
import mu.KLogging
import org.springframework.stereotype.Component
import java.io.File

@Component
class DiskDataService() : DataClient {

    companion object : KLogging()

    override fun save(id: String, data: String) {
        logger.info { "Trying to write data to disk. File name: $id Data: $data" }
        val logFile = File(id)
        logFile.createNewFile()
        logFile.appendText(data)
    }

    override fun load(id: String): String {
        NotImplementedError("DiskDataService.load() is currently not implemented")
        return "Not yet implemented"
    }
}
