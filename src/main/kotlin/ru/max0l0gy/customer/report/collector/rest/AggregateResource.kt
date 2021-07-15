package ru.max0l0gy.customer.report.collector.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.max0l0gy.customer.report.collector.service.AggregateService

@RestController
@RequestMapping("/v1/aggregate")
class AggregateResource(
    private val aggregateService: AggregateService
) {
    @GetMapping("/report/{customerId}")
    fun reports(@PathVariable("customerId") customerId: Long) = aggregateService.aggregate(customerId)
}
