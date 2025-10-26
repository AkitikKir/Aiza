package com.akitik.aiza.data.api

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.*
import okio.ByteString
import java.util.concurrent.TimeUnit

class StreamWebSocketClient(
    private val client: OkHttpClient,
    private val baseUrl: String
) {
    private var ws: WebSocket? = null

    /**
     * Starts a streaming websocket. Returns a cold Flow of String tokens (partial text).
     * Authorization example: "Bearer <API_KEY>"
     */
    fun streamChat(
        apiKey: String,
        model: String,
        messages: List<ChatMessagePayload>
    ): Flow<String> =
        callbackFlow {
            val reqBody =
                Json.encodeToString(ChatCompletionRequest(model = model, messages = messages))
            // Build request — assuming server expects WebSocket at /v1/chat/ws or /v1/stream
            val wsUrl = baseUrl.removeSuffix("/") + "/v1/chat/stream" // adjust as needed
            val request = Request.Builder()
                .url(wsUrl)
                .addHeader("Authorization", "Bearer $apiKey")
                .build()

            val listener = object : WebSocketListener() {
                override fun onOpen(webSocket: WebSocket, response: Response) {
                    // send initial request
                    webSocket.send(reqBody)
                }

                override fun onMessage(webSocket: WebSocket, text: String) {
                    // text could be JSON chunk or raw token; push into flow
                    trySend(text)
                }

                override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                    trySend(bytes.utf8())
                }

                override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                    webSocket.close(1000, null)
                    close()
                }

                override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                    close(t)
                }
            }

            ws = client.newWebSocket(request, listener)
            // keep callbackFlow open until cancelled
            awaitClose {
                ws?.close(1000, "client closed")
                ws = null
            }
        }
}