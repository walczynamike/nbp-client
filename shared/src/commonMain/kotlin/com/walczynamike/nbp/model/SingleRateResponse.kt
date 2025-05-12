package com.walczynamike.nbp.model

import kotlinx.serialization.Serializable

@Serializable
data class SingleRateResponse(
    /**
     * Type of the exchange rate table. Possible values:
     * 	* A – average exchange rates
     * 	* B – less frequently traded currencies
     * 	* C – bid and ask rates (buy/sell)
     */
    val table: String,
    /**
     * The full name of the currency in Polish (e.g., “dolar amerykański”, “euro”, "frank szwajcarski").
     */
    val currency: String,
    /**
     * The three-letter ISO 4217 code of the currency (e.g., “USD”, “EUR”).
     */
    val code: String,
    /**
     * A list of individual currency rate entries included in the table.
     */
    val rates: List<RateEntry>,
)