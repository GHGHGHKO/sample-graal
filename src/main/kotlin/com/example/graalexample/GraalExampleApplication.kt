package com.example.graalexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraalExampleApplication

fun main(args: Array<String>) {
	runApplication<GraalExampleApplication>(*args)
}
