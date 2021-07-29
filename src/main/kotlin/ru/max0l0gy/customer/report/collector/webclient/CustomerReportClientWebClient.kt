package ru.max0l0gy.customer.report.collector.webclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import ru.max0l0gy.customer.report.collector.domain.Report
import ru.max0l0gy.customer.report.collector.domain.RestResponse


@Component
class CustomerReportClientWebClient(
    val webClient: WebClient,
    @Value("\${external.customer-report-calculation.reports}")
    private var url: String
) : CustomerReportClient {

    override fun reportBy(customerId: Long): Mono<RestResponse<Report>> {
        val typeRef: ParameterizedTypeReference<RestResponse<Report>> = object : ParameterizedTypeReference<RestResponse<Report>>() {}
        val urlWithParams : String = url.replace("{customerId}", customerId.toString())

        return webClient
            .get()
            .uri(urlWithParams)
            .attribute("customerId", customerId)
            .accept(APPLICATION_JSON)
            .retrieve()
            .bodyToMono(typeRef)
    }

}

