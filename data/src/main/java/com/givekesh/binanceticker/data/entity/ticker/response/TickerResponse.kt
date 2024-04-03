package com.givekesh.binanceticker.data.entity.ticker.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TickerResponse(
    @Json(name = "s")
    val symbol: String,
    @Json(name = "P")
    val priceChangePercentage: String,
    @Json(name = "c")
    val lastPrice: String,
)
