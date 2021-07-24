package ru.max0l0gy.customer.report.collector.webclient

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.ActiveProfiles
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import ru.max0l0gy.customer.report.collector.domain.Report
import ru.max0l0gy.customer.report.collector.domain.RestResponse
import java.math.BigDecimal

@ActiveProfiles("test")
@AutoConfigureWebTestClient
@AutoConfigureWireMock(port = 0)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerReportClientTest(
    @Autowired var customerReportClient: CustomerReportClient
) {

    @Test
    fun loadContext() {
        assertNotNull(customerReportClient)
    }

    @Test
    fun reports() {
        val reportResponse: Mono<RestResponse<Report>> = customerReportClient.reportBy(101)
        StepVerifier.create(reportResponse)
            .expectNextMatches {
                it.status == "success"
                it.currentTimestamp == 1626123390169L
                it.data.customerId == 101L
                it.data.sale?.equals(BigDecimal.valueOf(25)) ?: false
                it.data.processTimeInMillis == 5000L
            }
            .verifyComplete()
    }

}