package com.givekesh.binanceticker.domain.model.ticker.response

data class Ticker(
    val symbol: String,
    val priceChangePercentage: String,
    val lastPrice: String,
)
