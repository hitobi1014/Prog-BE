package com.prog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class BackEndApplication

fun main(args: Array<String>) {
    runApplication<BackEndApplication>(*args)
}