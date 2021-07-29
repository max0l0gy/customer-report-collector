package ru.max0l0gy.customer.report.collector.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ClientHttpConnector
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.time.Duration

@Configuration
class WebClientConfiguration ( @Value("\${external.customer-report-calculation.url}")
                               private var host: String) {
    @Bean
    fun webClientWithConnectAndReadTimeOuts(): WebClient {
        val connector: ClientHttpConnector = ReactorClientHttpConnector(
            HttpClient.create()
                .baseUrl(host)
                .responseTimeout(Duration.ofSeconds(33))
        )
        return WebClient.builder().clientConnector(connector).build()
    }
}
