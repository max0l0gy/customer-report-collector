package ru.max0l0gy.customer.report.collector.feign

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono
import ru.max0l0gy.customer.report.collector.domain.Report
import ru.max0l0gy.customer.report.collector.domain.RestResponse


@ReactiveFeignClient(name = "customer-report-calculation", url = "\${external.customer-report-calculation.url}")
interface CustomerReportClient {
    @GetMapping("\${external.customer-report-calculation.reports}")
    fun reportBy(@PathVariable("customerId") customerId: Long): Mono<RestResponse<Report>>
}