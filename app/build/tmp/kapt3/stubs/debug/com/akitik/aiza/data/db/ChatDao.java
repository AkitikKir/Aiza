package com.akitik.aiza.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.akitik.aiza.data.db.entities.ChatMessage;
import com.akitik.aiza.data.db.entities.Conversation;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\b2\u0006\u0010\r\u001a\u00020\u0005H\'J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/akitik/aiza/data/db/ChatDao;", "", "deleteMessage", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConversations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/akitik/aiza/data/db/entities/Conversation;", "getMessagesForConversation", "Lcom/akitik/aiza/data/db/entities/ChatMessage;", "conversationId", "insertConversation", "conv", "(Lcom/akitik/aiza/data/db/entities/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMessage", "msg", "(Lcom/akitik/aiza/data/db/entities/ChatMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ChatDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertMessage(@org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.db.entities.ChatMessage msg, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertConversation(@org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.db.entities.Conversation conv, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM messages WHERE conversationId = :conversationId ORDER BY timestamp ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.akitik.aiza.data.db.entities.ChatMessage>> getMessagesForConversation(long conversationId);
    
    @androidx.room.Query(value = "SELECT * FROM conversations ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.akitik.aiza.data.db.entities.Conversation>> getConversations();
    
    @androidx.room.Query(value = "DELETE FROM messages WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMessage(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}