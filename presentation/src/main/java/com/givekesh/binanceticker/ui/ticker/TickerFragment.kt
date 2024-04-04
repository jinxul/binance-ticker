package com.givekesh.binanceticker.ui.ticker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.givekesh.binanceticker.databinding.FragmentTickerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TickerFragment : Fragment() {

    private var _binding: FragmentTickerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var _tickerAdapter: TickerAdapter? = null
    private val tickerAdapter get() = _tickerAdapter!!

    private val viewModel: TickerViewModel by viewModels()
    private var tickerJob: Job? = null

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
        subscribeToTicker()
        getTickerData()
    }

    private fun subscribeToTicker() {
        tickerJob = viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tickerDataState.collectLatest { tickerData ->
                tickerAdapter.updateItems(tickerData)
            }
        }
    }

    private fun getTickerData() {
        viewModel.listenToTicker()
    }

    private fun setupAdapter() {
        if (_tickerAdapter == null) {
            _tickerAdapter = TickerAdapter()
        }
        binding.tickerList.adapter = tickerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tickerJob?.cancel()
        tickerJob = null
        _tickerAdapter = null
        _binding = null
    }
}