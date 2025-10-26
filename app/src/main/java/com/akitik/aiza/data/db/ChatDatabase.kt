package com.akitik.aiza.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akitik.aiza.data.db.entities.ChatMessage
import com.akitik.aiza.data.db.entities.Conversation

@Database(entities = [ChatMessage::class, Conversation::class], version = 1)
abstract class ChatDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
}
