package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class SingleGoldPrice(
    /**
     * The date of the gold price publication in ISO format (e.g., "2025-05-12").
     */
    val data: String,
    /**
     * The price of 1 gram of gold (in PLN) as calculated by NBP for the given date.
     */
    val cena: Double,
)