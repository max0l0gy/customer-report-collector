package ru.max0l0gy.customer.report.collector.domain

import java.math.BigDecimal

data class Report (val customerId: Long? = null,
                   val sale: BigDecimal? = null,
                   val processTimeInMillis: Long? = null)