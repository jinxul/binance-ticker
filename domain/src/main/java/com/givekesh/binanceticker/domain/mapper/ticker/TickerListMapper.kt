package com.givekesh.binanceticker.domain.mapper.ticker

import com.givekesh.binanceticker.data.entity.ticker.response.TickerResponse
import com.givekesh.binanceticker.domain.model.response.Ticker
import com.givekesh.binanceticker.domain.util.ListToListMapper
import javax.inject.Inject

internal class TickerListMapper @Inject constructor(
    private val tickerMapper: TickerMapper,
) : ListToListMapper<TickerResponse, Ticker> {
    override fun toList(from: List<TickerResponse>): List<Ticker> {
        return from.map { tickerMapper.toObject(it) }
    }
}