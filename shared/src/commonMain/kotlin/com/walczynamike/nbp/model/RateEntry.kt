package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class RateEntry(
    /**
     * Unique number identifying the exchange rate table. Each table has a distinct identifier that includes the year.
     */
    val no: String,
    /**
     * The publication date of the exchange rate table. This is when the rates become officially valid.
     */
    val effectiveDate: String,
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