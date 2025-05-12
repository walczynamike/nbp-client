package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class Rate(
    /**
     * The full name of the currency in Polish (e.g., “dolar amerykański”, “euro”, "frank szwajcarski").
     */
    val currency: String,
    /**
     * The three-letter ISO 4217 code of the currency (e.g., “USD”, “EUR”).
     */
    val code: String,
    /**
     * The average exchange rate (in PLN) for the foreign currency. Only present in Tables A and B.
     */
    val mid: Double? = null,
    /**
     * The bid rate (price in PLN for buying the foreign currency). Only applicable to Table C.
     */
    val bid: Double? = null,
    /**
     * The ask rate (price in PLN for selling the foreign currency). Only applicable to Table C.
     */
    val ask: Double? = null,
)