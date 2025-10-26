package com.akitik.aiza.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akitik.aiza.data.db.entities.ChatMessage
import com.akitik.aiza.data.db.entities.Conversation
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(msg: ChatMessage): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConversation(conv: Conversation): Long

    @Query("SELECT * FROM messages WHERE conversationId = :conversationId ORDER BY timestamp ASC")
    fun getMessagesForConversation(conversationId: Long): Flow<List<ChatMessage>>

    @Query("SELECT * FROM conversations ORDER BY createdAt DESC")
    fun getConversations(): Flow<List<Conversation>>

    @Query("DELETE FROM messages WHERE id = :id")
    suspend fun deleteMessage(id: Long)
}
