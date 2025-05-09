package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateTable(
    val table: String,
    val no: String,
    val effectiveDate: String,
    val rates: List<Rate>
)