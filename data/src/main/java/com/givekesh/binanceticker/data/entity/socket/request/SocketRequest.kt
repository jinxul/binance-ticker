package com.givekesh.binanceticker.data.entity.socket.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SocketRequest(
    @Json(name = "method")
    val method: String,
    @Json(name = "params")
    val params: List<String>,
)
