package com.walczynamike.nbp.client

import com.walczynamike.nbp.ktor.createNbpHttpClient
import com.walczynamike.nbp.ktor.ktorHttpClientEngine
import com.walczynamike.nbp.model.CurrencyCode
import com.walczynamike.nbp.model.ExchangeRateTable
import com.walczynamike.nbp.model.LocalDate
import com.walczynamike.nbp.model.NbpTable
import com.walczynamike.nbp.model.SingleRateResponse
import com.walczynamike.nbp.model.toFormattedDate
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NbpExchangeRateClient internal constructor(
    private val client: HttpClient,
) : ExchangeRateClient {

    override suspend fun getCurrentTable(table: NbpTable): ExchangeRateTable =
        client.get("exchangerates/tables/${table.value}/").body<List<ExchangeRateTable>>().first()

    override suspend fun getLastTables(table: NbpTable, topCount: Int): List<ExchangeRateTable> =
        client.get("exchangerates/tables/${table.value}/last/$topCount/").body()

    override suspend fun getTableByDate(table: NbpTable, date: LocalDate): ExchangeRateTable {
        val dateString = date.toFormattedDate()
        return client.get("exchangerates/tables/${table.value}/$dateString/")
            .body<List<ExchangeRateTable>>()
            .first()
    }

    override suspend fun getTablesInRange(
        table: NbpTable,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<ExchangeRateTable> {
        val startDateString = startDate.toFormattedDate()
        val endDateString = endDate.toFormattedDate()
        return client.get("exchangerates/tables/${table.value}/$startDateString/$endDateString/").body()
    }

    override suspend fun getCurrentCurrencyRate(table: NbpTable, currencyCode: CurrencyCode): SingleRateResponse =
        client.get("exchangerates/rates/${table.value}/${currencyCode.code}/").body()

    override suspend fun getLastCurrencyRates(
        table: NbpTable,
        currencyCode: CurrencyCode,
        topCount: Int,
    ): SingleRateResponse =
        client.get("exchangerates/rates/${table.value}/${currencyCode.code}/last/$topCount/").body()

    override suspend fun getCurrencyRateByDate(
        table: NbpTable,
        currencyCode: CurrencyCode,
        date: LocalDate,
    ): SingleRateResponse {
        val dateString = date.toFormattedDate()
        return client.get("exchangerates/rates/${table.value}/${currencyCode.code}/$dateString/").body()
    }

    override suspend fun getCurrencyRatesInRange(
        table: NbpTable,
        currencyCode: CurrencyCode,
        startDate: LocalDate,
        endDate: LocalDate,
    ): SingleRateResponse {
        val startDateString = startDate.toFormattedDate()
        val endDateString = endDate.toFormattedDate()
        return client.get("exchangerates/rates/${table.value}/${currencyCode.code}/$startDateString/$endDateString/").body()
    }

    companion object {
        fun create(): NbpExchangeRateClient = NbpExchangeRateClient(
            client = createNbpHttpClient(engine = ktorHttpClientEngine)
        )
    }
}