package com.akitik.aiza.data.repository;

import com.akitik.aiza.data.api.ChatCompletionRequest;
import com.akitik.aiza.data.api.ChatMessagePayload;
import com.akitik.aiza.data.api.ChatCompletionResponse;
import com.akitik.aiza.data.db.ChatDao;
import com.akitik.aiza.data.db.entities.ChatMessage;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlinx.coroutines.Dispatchers;
import com.akitik.aiza.data.api.OpenRouterApi;
import com.akitik.aiza.data.api.StreamWebSocketClient;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@\u00a2\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/akitik/aiza/data/repository/ChatRepositoryImpl;", "Lcom/akitik/aiza/data/repository/ChatRepository;", "api", "Lcom/akitik/aiza/data/api/OpenRouterApi;", "wsClient", "Lcom/akitik/aiza/data/api/StreamWebSocketClient;", "dao", "Lcom/akitik/aiza/data/db/ChatDao;", "(Lcom/akitik/aiza/data/api/OpenRouterApi;Lcom/akitik/aiza/data/api/StreamWebSocketClient;Lcom/akitik/aiza/data/db/ChatDao;)V", "getConversations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/akitik/aiza/data/db/entities/Conversation;", "getMessages", "Lcom/akitik/aiza/data/db/entities/ChatMessage;", "conversationId", "", "saveMessage", "msg", "(Lcom/akitik/aiza/data/db/entities/ChatMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageRest", "Lcom/akitik/aiza/data/api/ChatCompletionResponse;", "apiKey", "", "request", "Lcom/akitik/aiza/data/api/ChatCompletionRequest;", "(Ljava/lang/String;Lcom/akitik/aiza/data/api/ChatCompletionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "streamMessage", "model", "messages", "Lcom/akitik/aiza/data/api/ChatMessagePayload;", "app_debug"})
public final class ChatRepositoryImpl implements com.akitik.aiza.data.repository.ChatRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.akitik.aiza.data.api.OpenRouterApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.akitik.aiza.data.api.StreamWebSocketClient wsClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.akitik.aiza.data.db.ChatDao dao = null;
    
    @javax.inject.Inject()
    public ChatRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.api.OpenRouterApi api, @org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.api.StreamWebSocketClient wsClient, @org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.db.ChatDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object sendMessageRest(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.api.ChatCompletionRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.akitik.aiza.data.api.ChatCompletionResponse> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> streamMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.util.List<com.akitik.aiza.data.api.ChatMessagePayload> messages) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveMessage(@org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.db.entities.ChatMessage msg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.akitik.aiza.data.db.entities.ChatMessage>> getMessages(long conversationId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.akitik.aiza.data.db.entities.Conversation>> getConversations() {
        return null;
    }
}