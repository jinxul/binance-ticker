package com.givekesh.binanceticker.domain.usecase.socket

import com.givekesh.binanceticker.data.entity.ticker.response.TickerResponse
import com.givekesh.binanceticker.data.source.remote.repository.socket.SocketRepository
import com.givekesh.binanceticker.data.util.SocketListener
import com.givekesh.binanceticker.domain.mapper.ticker.TickerListMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class SocketUseCaseImpl @Inject constructor(
    private val socketRepository: SocketRepository,
    private val tickerListMapper: TickerListMapper,
) : SocketUseCase {
    override fun listenToTicker() = channelFlow {
        val listener = object : SocketListener<List<TickerResponse>> {
            override fun onMessage(response: List<TickerResponse>) {
                tickerListMapper.toList(response)
                    .also { trySend(it) }
            }
        }
        socketRepository.listenToTicker(listener)
        awaitClose()
    }.flowOn(Dispatchers.IO)
}