package ru.max0l0gy.customer.report.collector.webclient

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Mono
import ru.max0l0gy.customer.report.collector.domain.Report
import ru.max0l0gy.customer.report.collector.domain.RestResponse


interface CustomerReportClient {


    @GetMapping("\${external.customer-report-calculation.reports}")
    fun reportBy(@PathVariable("customerId") customerId: Long): Mono<RestResponse<Report>>
}