package com.walczynamike.nbp.client

import com.walczynamike.nbp.ktor.createNbpHttpClient
import com.walczynamike.nbp.ktor.ktorHttpClientEngine
import com.walczynamike.nbp.model.ExchangeRateTable
import com.walczynamike.nbp.model.LocalDate
import com.walczynamike.nbp.model.SingleRateResponse
import com.walczynamike.nbp.model.toFormattedDate
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NbpExchangeRateClient internal constructor(
    private val client: HttpClient,
) : ExchangeRateClient {

    override suspend fun getCurrentTable(table: String): ExchangeRateTable =
        client.get("exchangerates/tables/$table/").body<List<ExchangeRateTable>>().first()

    override suspend fun getLastTables(table: String, topCount: Int): List<ExchangeRateTable> =
        client.get("exchangerates/tables/$table/last/$topCount/").body()

    override suspend fun getTableByDate(table: String, date: LocalDate): ExchangeRateTable {
        val dateString = date.toFormattedDate()
        return client.get("exchangerates/tables/$table/$dateString/")
            .body<List<ExchangeRateTable>>()
            .first()
    }

    override suspend fun getTablesInRange(
        table: String,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<ExchangeRateTable> {
        val startDateString = startDate.toFormattedDate()
        val endDateString = endDate.toFormattedDate()
        return client.get("exchangerates/tables/$table/$startDateString/$endDateString/").body()
    }

    override suspend fun getCurrentCurrencyRate(table: String, code: String): SingleRateResponse =
        client.get("exchangerates/rates/$table/$code/").body()

    override suspend fun getLastCurrencyRates(
        table: String,
        code: String,
        topCount: Int,
    ): SingleRateResponse =
        client.get("exchangerates/rates/$table/$code/last/$topCount/").body()

    override suspend fun getCurrencyRateByDate(
        table: String,
        code: String,
        date: LocalDate,
    ): SingleRateResponse {
        val dateString = date.toFormattedDate()
        return client.get("exchangerates/rates/$table/$code/$dateString/").body()
    }

    override suspend fun getCurrencyRatesInRange(
        table: String,
        code: String,
        startDate: LocalDate,
        endDate: LocalDate,
    ): SingleRateResponse {
        val startDateString = startDate.toFormattedDate()
        val endDateString = endDate.toFormattedDate()
        return client.get("exchangerates/rates/$table/$code/$startDateString/$endDateString/").body()
    }

    companion object {
        fun create(): NbpExchangeRateClient = NbpExchangeRateClient(
            client = createNbpHttpClient(engine = ktorHttpClientEngine)
        )
    }
}