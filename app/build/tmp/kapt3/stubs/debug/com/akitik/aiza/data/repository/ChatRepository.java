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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u0013J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004H&\u00a8\u0006\u0018"}, d2 = {"Lcom/akitik/aiza/data/repository/ChatRepository;", "", "getConversations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/akitik/aiza/data/db/entities/Conversation;", "getMessages", "Lcom/akitik/aiza/data/db/entities/ChatMessage;", "conversationId", "", "saveMessage", "msg", "(Lcom/akitik/aiza/data/db/entities/ChatMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageRest", "Lcom/akitik/aiza/data/api/ChatCompletionResponse;", "apiKey", "", "request", "Lcom/akitik/aiza/data/api/ChatCompletionRequest;", "(Ljava/lang/String;Lcom/akitik/aiza/data/api/ChatCompletionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "streamMessage", "model", "messages", "Lcom/akitik/aiza/data/api/ChatMessagePayload;", "app_debug"})
public abstract interface ChatRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendMessageRest(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.api.ChatCompletionRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.akitik.aiza.data.api.ChatCompletionResponse> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> streamMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.util.List<com.akitik.aiza.data.api.ChatMessagePayload> messages);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveMessage(@org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.db.entities.ChatMessage msg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.akitik.aiza.data.db.entities.ChatMessage>> getMessages(long conversationId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.akitik.aiza.data.db.entities.Conversation>> getConversations();
}