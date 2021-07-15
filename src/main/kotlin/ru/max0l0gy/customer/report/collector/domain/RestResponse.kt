package ru.max0l0gy.customer.report.collector.domain

data class RestResponse<T>(
    val status: String,
    val currentTimestamp: Long,
    val data: T
)