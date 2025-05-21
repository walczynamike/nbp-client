package com.walczynamike.nbp.client

import com.walczynamike.nbp.model.ExchangeRateTable
import com.walczynamike.nbp.model.LocalDate
import com.walczynamike.nbp.model.SingleRateResponse

interface ExchangeRateClient {
    suspend fun getCurrentTable(table: String): ExchangeRateTable
    suspend fun getLastTables(table: String, topCount: Int): List<ExchangeRateTable>
    suspend fun getTableByDate(table: String, date: LocalDate): ExchangeRateTable
    suspend fun getTablesInRange(
        table: String,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<ExchangeRateTable>

    suspend fun getCurrentCurrencyRate(table: String, code: String): SingleRateResponse
    suspend fun getLastCurrencyRates(table: String, code: String, topCount: Int): SingleRateResponse
    suspend fun getCurrencyRateByDate(
        table: String,
        code: String,
        date: LocalDate,
    ): SingleRateResponse

    suspend fun getCurrencyRatesInRange(
        table: String,
        code: String,
        startDate: LocalDate,
        endDate: LocalDate,
    ): SingleRateResponse
}