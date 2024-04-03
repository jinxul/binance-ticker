package com.givekesh.binanceticker.data.util

interface SocketListener {
    fun onMessage(text: String)
}