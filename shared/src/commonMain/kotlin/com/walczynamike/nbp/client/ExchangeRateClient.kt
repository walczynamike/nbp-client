package com.walczynamike.nbp.client

import com.walczynamike.nbp.model.CurrencyCode
import com.walczynamike.nbp.model.ExchangeRateTable
import com.walczynamike.nbp.model.LocalDate
import com.walczynamike.nbp.model.NbpTable
import com.walczynamike.nbp.model.SingleRateResponse

interface ExchangeRateClient {
    suspend fun getCurrentTable(table: NbpTable): ExchangeRateTable
    suspend fun getLastTables(table: NbpTable, topCount: Int): List<ExchangeRateTable>
    suspend fun getTableByDate(table: NbpTable, date: LocalDate): ExchangeRateTable
    suspend fun getTablesInRange(
        table: NbpTable,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<ExchangeRateTable>

    suspend fun getCurrentCurrencyRate(table: NbpTable, currencyCode: CurrencyCode): SingleRateResponse
    suspend fun getLastCurrencyRates(table: NbpTable, currencyCode: CurrencyCode, topCount: Int): SingleRateResponse
    suspend fun getCurrencyRateByDate(
        table: NbpTable,
        currencyCode: CurrencyCode,
        date: LocalDate,
    ): SingleRateResponse

    suspend fun getCurrencyRatesInRange(
        table: NbpTable,
        currencyCode: CurrencyCode,
        startDate: LocalDate,
        endDate: LocalDate,
    ): SingleRateResponse
}