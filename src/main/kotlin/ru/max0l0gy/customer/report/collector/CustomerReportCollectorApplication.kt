package ru.max0l0gy.customer.report.collector

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactivefeign.spring.config.EnableReactiveFeignClients

@SpringBootApplication
@EnableReactiveFeignClients
class CustomerReportCollectorApplication

fun main(args: Array<String>) {
    runApplication<CustomerReportCollectorApplication>(*args)
}




