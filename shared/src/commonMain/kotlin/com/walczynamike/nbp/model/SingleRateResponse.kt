package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class SingleRateResponse(
    val table: String,
    val currency: String,
    val code: String,
    val rates: List<RateEntry>
)