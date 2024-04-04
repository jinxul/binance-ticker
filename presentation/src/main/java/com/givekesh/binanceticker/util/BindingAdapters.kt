package com.givekesh.binanceticker.util

import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.givekesh.binanceticker.R
import com.google.android.material.textview.MaterialTextView


object BindingAdapters {
    @JvmStatic
    @BindingAdapter("setPrice")
    fun setPrice(view: MaterialTextView, price: String) {
        view.text = view.context.getString(R.string.price_in_usd, price)
    }

    @JvmStatic
    @BindingAdapter("setPricePercentageChange")
    fun setPricePercentageChange(view: MaterialTextView, priceChange: String) {
        val textColor = when {
            priceChange.contains("-") -> R.color.red
            else -> R.color.green
        }.let { ContextCompat.getColor(view.context, it) }
        view.setTextColor(textColor)
        view.text = view.context.getString(R.string.price_percentage, priceChange)
    }
}