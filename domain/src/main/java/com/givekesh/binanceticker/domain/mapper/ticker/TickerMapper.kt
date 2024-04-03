package com.givekesh.binanceticker.domain.mapper.ticker

import com.givekesh.binanceticker.data.entity.ticker.response.TickerResponse
import com.givekesh.binanceticker.domain.model.response.Ticker
import com.givekesh.binanceticker.domain.util.ObjectToObjectMapper
import javax.inject.Inject

internal class TickerMapper @Inject constructor() : ObjectToObjectMapper<TickerResponse, Ticker> {
    override fun toObject(from: TickerResponse) = Ticker(
        symbol = from.symbol,
        priceChangePercentage = from.priceChangePercentage,
        lastPrice = from.lastPrice,
    )
}