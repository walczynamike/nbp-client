package com.walczynamike.nbp.client

import com.walczynamike.nbp.model.LocalDate
import com.walczynamike.nbp.model.SingleGoldPrice

interface GoldPricesClient {
    suspend fun getCurrentPrice(): SingleGoldPrice
    suspend fun getLastPrices(topCount: Int): List<SingleGoldPrice>
    suspend fun getPriceToday(): SingleGoldPrice
    suspend fun getPriceOnDate(date: LocalDate): SingleGoldPrice
    suspend fun getPricesInRange(startDate: LocalDate, endDate: LocalDate): List<SingleGoldPrice>
}
