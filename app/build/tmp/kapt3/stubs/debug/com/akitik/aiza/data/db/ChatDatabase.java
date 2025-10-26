package com.akitik.aiza.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.akitik.aiza.data.db.entities.ChatMessage;
import com.akitik.aiza.data.db.entities.Conversation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/akitik/aiza/data/db/ChatDatabase;", "Landroidx/room/RoomDatabase;", "()V", "chatDao", "Lcom/akitik/aiza/data/db/ChatDao;", "app_debug"})
@androidx.room.Database(entities = {com.akitik.aiza.data.db.entities.ChatMessage.class, com.akitik.aiza.data.db.entities.Conversation.class}, version = 1)
public abstract class ChatDatabase extends androidx.room.RoomDatabase {
    
    public ChatDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.akitik.aiza.data.db.ChatDao chatDao();
}