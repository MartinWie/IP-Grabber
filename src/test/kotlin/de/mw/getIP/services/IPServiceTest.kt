package de.mw.getIP.services

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.mock.web.MockHttpServletRequest

@MockBean
class IPServiceTest {
    private lateinit var ipService: IPService

    @BeforeEach
    fun initService() {
        ipService = IPService()
    }

    @Test
    fun `Test if extracting the ip from the request works as expected`() {
        val request = MockHttpServletRequest()
        request.remoteAddr = "1.1.1.1"
        val result = ipService.getCallerIP(request)
        Assertions.assertEquals("1.1.1.1", result)
    }

    @Test
    fun `Test if gathering the data from the request works as expected`() {
        val request = MockHttpServletRequest()
        request.remoteAddr = "1.1.1.1"
        request.remoteHost = "madmax"
        request.remotePort = 4321
        val result = ipService.getCallerAccessData(request, "id123")

        Assertions.assertTrue(result.contains("Path ID: id123"))
        Assertions.assertTrue(result.contains("Remote host: madmax"))
        Assertions.assertTrue(result.contains("Remote address: 1.1.1.1"))
        Assertions.assertTrue(result.contains("Remote port: 4321"))
    }
}
