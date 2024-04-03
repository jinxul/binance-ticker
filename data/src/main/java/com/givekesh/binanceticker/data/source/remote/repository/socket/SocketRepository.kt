package com.givekesh.binanceticker.data.source.remote.repository.socket

import com.givekesh.binanceticker.data.util.SocketListener

interface SocketRepository {
    fun listenToTicker(listener: SocketListener)
}