package de.mw.getIP

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("de.mw.getIP"))
class GetIpApplication

fun main(args: Array<String>) {
    runApplication<GetIpApplication>(*args)
}

@RestController
class Default {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    fun default() {
    }
}
