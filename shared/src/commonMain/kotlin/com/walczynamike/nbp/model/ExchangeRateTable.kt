package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateTable(
    /**
     * Type of the exchange rate table. Possible values:
     * 	* A – average exchange rates
     * 	* B – less frequently traded currencies
     * 	* C – bid and ask rates (buy/sell)
     */
    val table: String,
    /**
     * Unique number identifying the exchange rate table. Each table has a distinct identifier that includes the year.
     */
    val no: String,
    /**
     * The publication date of the exchange rate table. This is when the rates become officially valid.
     */
    val effectiveDate: String,
    /**
     * A list of individual currency rate entries included in the table.
     */
    val rates: List<Rate>,
)