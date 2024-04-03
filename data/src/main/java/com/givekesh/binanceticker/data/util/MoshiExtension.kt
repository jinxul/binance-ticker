package com.givekesh.binanceticker.data.util

import android.util.Log
import com.squareup.moshi.Moshi

internal inline fun <reified T> Moshi.fromJson(
    jsonObject: Any
): T? = try {
    adapter(T::class.java).fromJson(jsonObject.toString())
} catch (e: Exception) {
    Log.e("fromJson", "$jsonObject")
    Log.e("fromJson", "$e", e)
    null
}

internal inline fun <reified T> Moshi.toJson(
    jsonObject: T
): String? = try {
    adapter(T::class.java).toJson(jsonObject)
} catch (e: Exception) {
    Log.e("toJson", "$jsonObject")
    Log.e("toJson", "$e", e)
    null
}