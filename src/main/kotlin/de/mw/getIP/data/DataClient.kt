package de.mw.getIP.data

interface DataClient {
    fun save(id: String, data: String)
    fun load(id: String): String
}
