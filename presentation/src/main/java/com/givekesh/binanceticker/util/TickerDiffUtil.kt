package com.givekesh.binanceticker.util

import androidx.recyclerview.widget.DiffUtil
import com.givekesh.binanceticker.domain.model.ticker.response.Ticker

object TickerDiffUtil : DiffUtil.ItemCallback<Ticker>() {
    override fun areItemsTheSame(
        oldItem: Ticker,
        newItem: Ticker
    ): Boolean = oldItem.symbol == newItem.symbol

    override fun areContentsTheSame(
        oldItem: Ticker,
        newItem: Ticker
    ): Boolean = oldItem == newItem
}