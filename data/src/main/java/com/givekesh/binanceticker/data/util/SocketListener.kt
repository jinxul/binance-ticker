package com.givekesh.binanceticker.data.util

interface SocketListener<T> {
    fun onMessage(response: T)
}