package ru.max0l0gy.customer.report.collector.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import ru.max0l0gy.customer.report.collector.domain.Report
import ru.max0l0gy.customer.report.collector.domain.RestResponse
import ru.max0l0gy.customer.report.collector.feign.CustomerReportClient

@Service
class AggregateService (
    private val customerReportClient: CustomerReportClient
) {

    fun aggregate(customerId: Long) : Mono<RestResponse<Report>> {
        return customerReportClient.reportBy(customerId)
            .subscribeOn(Schedulers.boundedElastic())
    }

}