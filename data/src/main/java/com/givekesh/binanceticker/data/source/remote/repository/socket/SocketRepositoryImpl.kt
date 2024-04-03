package com.givekesh.binanceticker.data.source.remote.repository.socket

import com.givekesh.binanceticker.data.entity.socket.request.SocketRequest
import com.givekesh.binanceticker.data.util.SocketListener
import com.givekesh.binanceticker.data.util.toJson
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject

internal class SocketRepositoryImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val request: Request,
    private val moshi: Moshi,
) : SocketRepository {
    @Volatile
    private var webSocket: WebSocket? = null

    @Synchronized
    override fun listenToTicker(listener: SocketListener) {
        if (webSocket == null) {
            webSocket = okHttpClient.newWebSocket(request, object : WebSocketListener() {
                override fun onOpen(webSocket: WebSocket, response: Response) {
                    super.onOpen(webSocket, response)
                    val request = SocketRequest(
                        method = "SUBSCRIBE",
                        params = listOf("!ticker@arr")
                    ).let { moshi.toJson(it) } ?: return
                    webSocket.send(request)
                }

                override fun onMessage(webSocket: WebSocket, text: String) {
                    super.onMessage(webSocket, text)
                    listener.onMessage(text)
                }
            })
        }
    }
}