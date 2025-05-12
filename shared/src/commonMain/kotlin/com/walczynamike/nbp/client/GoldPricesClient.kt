package com.walczynamike.nbp.client

import com.walczynamike.nbp.model.SingleGoldPrice

interface GoldPricesClient {
    suspend fun getCurrentPrice(): SingleGoldPrice
    suspend fun getLastPrices(topCount: Int): List<SingleGoldPrice>
    suspend fun getPriceToday(): SingleGoldPrice
    suspend fun getPriceOnDate(date: String): SingleGoldPrice
    suspend fun getPricesInRange(startDate: String, endDate: String): List<SingleGoldPrice>
}
