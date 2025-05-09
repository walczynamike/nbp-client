package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class Rate(
    val currency: String,
    val code: String,
    val mid: Double? = null, // for table A/B
    val bid: Double? = null, // for table C
    val ask: Double? = null  // for table C
)