package site.katchup.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KatchupserverApplication

fun main(args: Array<String>) {
    runApplication<KatchupserverApplication>(*args)
}
