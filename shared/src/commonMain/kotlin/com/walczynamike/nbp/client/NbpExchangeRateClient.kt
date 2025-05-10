package com.walczynamike.nbp.client

import com.walczynamike.nbp.ktor.nbpHttpClient
import com.walczynamike.nbp.model.ExchangeRateTable
import com.walczynamike.nbp.model.SingleRateResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NbpExchangeRateClient(
    private val client: HttpClient = nbpHttpClient,
) : ExchangeRateClient {

    override suspend fun getCurrentTable(table: String): List<ExchangeRateTable> =
        client.get("exchangerates/tables/$table/").body()

    override suspend fun getLastTables(table: String, topCount: Int): List<ExchangeRateTable> =
        client.get("exchangerates/tables/$table/last/$topCount/").body()

    override suspend fun getTableByDate(table: String, date: String): List<ExchangeRateTable> =
        client.get("exchangerates/tables/$table/$date/").body()

    override suspend fun getTablesInRange(table: String, startDate: String, endDate: String): List<ExchangeRateTable> =
        client.get("exchangerates/tables/$table/$startDate/$endDate/").body()

    override suspend fun getCurrentCurrencyRate(table: String, code: String): SingleRateResponse =
        client.get("exchangerates/rates/$table/$code/").body()

    override suspend fun getLastCurrencyRates(table: String, code: String, topCount: Int): SingleRateResponse =
        client.get("exchangerates/rates/$table/$code/last/$topCount/").body()

    override suspend fun getCurrencyRateByDate(table: String, code: String, date: String): SingleRateResponse =
        client.get("exchangerates/rates/$table/$code/$date/").body()

    override suspend fun getCurrencyRatesInRange(table: String, code: String, startDate: String, endDate: String): SingleRateResponse =
        client.get("exchangerates/rates/$table/$code/$startDate/$endDate/").body()
}