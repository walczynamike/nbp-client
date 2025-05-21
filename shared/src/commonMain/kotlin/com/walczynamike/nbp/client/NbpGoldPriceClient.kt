package com.walczynamike.nbp.client

import com.walczynamike.nbp.ktor.createNbpHttpClient
import com.walczynamike.nbp.ktor.ktorHttpClientEngine
import com.walczynamike.nbp.model.LocalDate
import com.walczynamike.nbp.model.SingleGoldPrice
import com.walczynamike.nbp.model.toFormattedDate
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NbpGoldPriceClient internal constructor(
    private val httpClient: HttpClient,
) : GoldPricesClient {

    override suspend fun getCurrentPrice(): SingleGoldPrice =
        httpClient.get("cenyzlota/").body<List<SingleGoldPrice>>().first()

    override suspend fun getLastPrices(topCount: Int): List<SingleGoldPrice> =
        httpClient.get("cenyzlota/last/$topCount/").body<List<SingleGoldPrice>>()

    override suspend fun getPriceToday(): SingleGoldPrice =
        httpClient.get("cenyzlota/today/").body<List<SingleGoldPrice>>().first()

    override suspend fun getPriceOnDate(date: LocalDate): SingleGoldPrice {
        val dateString = date.toFormattedDate()
        return httpClient.get("cenyzlota/$dateString/").body<List<SingleGoldPrice>>().first()
    }

    override suspend fun getPricesInRange(
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<SingleGoldPrice> {
        val startDateString = startDate.toFormattedDate()
        val endDateString = endDate.toFormattedDate()
        return httpClient.get("cenyzlota/$startDateString/$endDateString/").body()
    }

    companion object {
        fun create(): NbpGoldPriceClient {
            return NbpGoldPriceClient(
                httpClient = createNbpHttpClient(ktorHttpClientEngine),
            )
        }
    }
}