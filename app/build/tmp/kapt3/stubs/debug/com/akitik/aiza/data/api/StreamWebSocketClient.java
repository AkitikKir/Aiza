package com.akitik.aiza.data.api;

import kotlinx.coroutines.flow.Flow;
import okio.ByteString;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/akitik/aiza/data/api/StreamWebSocketClient;", "", "client", "Lokhttp3/OkHttpClient;", "baseUrl", "", "(Lokhttp3/OkHttpClient;Ljava/lang/String;)V", "ws", "Lokhttp3/WebSocket;", "streamChat", "Lkotlinx/coroutines/flow/Flow;", "apiKey", "model", "messages", "", "Lcom/akitik/aiza/data/api/ChatMessagePayload;", "app_debug"})
public final class StreamWebSocketClient {
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = null;
    @org.jetbrains.annotations.Nullable()
    private okhttp3.WebSocket ws;
    
    public StreamWebSocketClient(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl) {
        super();
    }
    
    /**
     * Starts a streaming websocket. Returns a cold Flow of String tokens (partial text).
     * Authorization example: "Bearer <API_KEY>"
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.String> streamChat(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.util.List<com.akitik.aiza.data.api.ChatMessagePayload> messages) {
        return null;
    }
}