package ru.max0l0gy.customer.report.collector.rest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@ActiveProfiles("test")
@AutoConfigureWebTestClient
@AutoConfigureWireMock(port = 0)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AggregateResourceTest(
    @Autowired private val webTestClient: WebTestClient
) {

    @Test
    fun aggregate() {
        webTestClient.get()
            .uri("/v1/aggregate/report/101")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.status").isEqualTo("success")
            .jsonPath("$.currentTimestamp").isEqualTo(1626123390169L)
            .jsonPath("$.data.customerId").isEqualTo(101)
            .jsonPath("$.data.sale").isEqualTo(25)
            .jsonPath("$.data.processTimeInMillis").isEqualTo(5000)
    }

}
