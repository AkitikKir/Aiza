package com.akitik.aiza.data.api

import kotlinx.serialization.Serializable

@Serializable
data class ChatCompletionRequest(
    val model: String,
    val messages: List<ChatMessagePayload>,
    val max_tokens: Int? = null,
    val temperature: Double? = null,
    val stop: List<String>? = null
)

@Serializable
data class ChatMessagePayload(
    val role: String, // "user" | "assistant" | "system"
    val content: String
)

@Serializable
data class ChatCompletionResponse(
    val id: String,
    val objectType: String? = null,
    val choices: List<Choice>
) {
    @Serializable
    data class Choice(
        val index: Int,
        val message: ChatMessagePayload,
        val finish_reason: String? = null
    )
}
