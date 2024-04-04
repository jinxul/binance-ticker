package com.givekesh.binanceticker.ui.ticker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.givekesh.binanceticker.databinding.FragmentTickerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TickerFragment : Fragment() {

    private var _binding: FragmentTickerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var _tickerAdapter: TickerAdapter? = null
    private val tickerAdapter get() = _tickerAdapter!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
    }

    private fun setupAdapter() {
        if (_tickerAdapter == null) {
            _tickerAdapter = TickerAdapter()
        }
        binding.tickerList.adapter = tickerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _tickerAdapter = null
        _binding = null
    }
}