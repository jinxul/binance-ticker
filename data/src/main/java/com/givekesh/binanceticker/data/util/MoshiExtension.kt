package com.givekesh.binanceticker.data.util

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

internal inline fun <reified T> Moshi.fromJson(
    jsonObject: Any
): T? = try {
    adapter(T::class.java).fromJson(jsonObject.toString())
} catch (e: Exception) {
    Log.e("fromJson", "$jsonObject")
    Log.e("fromJson", "$e", e)
    null
}

internal inline fun <reified T> Moshi.fromJsonList(
    jsonObject: Any
): List<T>? = try {
    val type = Types.newParameterizedType(
        List::class.java,
        T::class.java
    )
    val moshiAdapter: JsonAdapter<List<T>> = adapter(type)
    moshiAdapter.fromJson(jsonObject.toString())
} catch (e: Exception) {
    Log.e("fromJsonList", "$jsonObject")
    Log.e("fromJsonList", "$e", e)
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