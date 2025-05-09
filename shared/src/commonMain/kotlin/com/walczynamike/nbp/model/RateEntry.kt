package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class RateEntry(
    val no: String,
    val effectiveDate: String,
    val mid: Double? = null,
    val bid: Double? = null,
    val ask: Double? = null
)