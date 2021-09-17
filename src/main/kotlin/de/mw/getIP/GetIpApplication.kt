package de.mw.getIP

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("de.mw.getIP"))
class GetIpApplication

fun main(args: Array<String>) {
    runApplication<GetIpApplication>(*args)
}
