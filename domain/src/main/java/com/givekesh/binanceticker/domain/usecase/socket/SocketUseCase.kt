package com.givekesh.binanceticker.domain.usecase.socket

import com.givekesh.binanceticker.domain.model.response.Ticker
import kotlinx.coroutines.flow.Flow

interface SocketUseCase {
    fun listenToTicker(): Flow<List<Ticker>>
}