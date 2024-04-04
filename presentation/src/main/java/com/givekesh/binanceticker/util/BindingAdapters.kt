package com.givekesh.binanceticker.util

import androidx.core.content.ContextCompat
import java.text.NumberFormat
import androidx.databinding.BindingAdapter
import com.givekesh.binanceticker.R
import com.google.android.material.textview.MaterialTextView
import java.util.Locale


object BindingAdapters {
    @JvmStatic
    @BindingAdapter("setPrice")
    fun setPriceTextAndColor(view: MaterialTextView, price: String) {
        val formattedPrice = NumberFormat
            .getNumberInstance(Locale.US)
            .format(price.toDouble())
        view.text = view.context.getString(R.string.price_in_usd, formattedPrice)
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