package com.givekesh.binanceticker.ui.ticker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.givekesh.binanceticker.BR
import com.givekesh.binanceticker.databinding.ItemTickerBinding
import com.givekesh.binanceticker.domain.model.ticker.response.Ticker
import com.givekesh.binanceticker.util.TickerDiffUtil

class TickerAdapter : RecyclerView.Adapter<TickerViewHolder>() {
    private val differ = AsyncListDiffer(this, TickerDiffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTickerBinding.inflate(inflater,parent,false)
        return TickerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TickerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, BR.ticker)
    }

    override fun getItemCount(): Int = differ.currentList.size

    private fun getItem(position: Int): Ticker = differ.currentList[position]

    fun updateItems(items: List<Ticker>) = differ.submitList(items)
}

class TickerViewHolder(
    private val binding: ItemTickerBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Ticker, bindingVariableId: Int) {
        binding.setVariable(bindingVariableId, item)
    }
}