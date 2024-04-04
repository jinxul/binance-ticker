package com.givekesh.binanceticker.ui.ticker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.givekesh.binanceticker.domain.model.ticker.response.Ticker
import com.givekesh.binanceticker.domain.usecase.socket.SocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TickerViewModel @Inject constructor(
    private val socketUseCase: SocketUseCase,
) : ViewModel() {
    private val _tickerDataState = MutableStateFlow<List<Ticker>>(listOf())
    val tickerDataState = _tickerDataState.asStateFlow()

    fun listenToTicker() {
        viewModelScope.launch {
            socketUseCase.listenToTicker()
                .onEach { _tickerDataState.value = it }
                .launchIn(viewModelScope)
        }
    }
}