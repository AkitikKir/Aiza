package com.akitik.aiza.data.repository

import com.akitik.aiza.data.api.ChatCompletionRequest
import com.akitik.aiza.data.api.ChatMessagePayload
import com.akitik.aiza.data.api.ChatCompletionResponse
import com.akitik.aiza.data.db.ChatDao
import com.akitik.aiza.data.db.entities.ChatMessage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.akitik.aiza.data.api.OpenRouterApi
import com.akitik.aiza.data.api.StreamWebSocketClient

interface ChatRepository {
    suspend fun sendMessageRest(apiKey: String, request: ChatCompletionRequest): ChatCompletionResponse
    fun streamMessage(apiKey: String, model: String, messages: List<ChatMessagePayload>): Flow<String>
    suspend fun saveMessage(msg: ChatMessage): Long
    fun getMessages(conversationId: Long): Flow<List<ChatMessage>>
    fun getConversations(): Flow<List<com.akitik.aiza.data.db.entities.Conversation>>
}

@Singleton
class ChatRepositoryImpl @Inject constructor(
    private val api: OpenRouterApi,
    private val wsClient: StreamWebSocketClient,
    private val dao: ChatDao
) : ChatRepository {

    override suspend fun sendMessageRest(apiKey: String, request: ChatCompletionRequest) =
        withContext(Dispatchers.IO) {
            api.createCompletion("Bearer $apiKey", request)
        }

    override fun streamMessage(apiKey: String, model: String, messages: List<ChatMessagePayload>) =
        wsClient.streamChat(apiKey, model, messages)

    override suspend fun saveMessage(msg: ChatMessage): Long = dao.insertMessage(msg)

    override fun getMessages(conversationId: Long): Flow<List<ChatMessage>> =
        dao.getMessagesForConversation(conversationId)

    override fun getConversations() = dao.getConversations()
}
