package com.akitik.aiza.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akitik.aiza.data.api.ChatMessagePayload
import com.akitik.aiza.data.api.ChatCompletionRequest
import com.akitik.aiza.data.repository.ChatRepository
import com.akitik.aiza.data.db.entities.ChatMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UiMessage(val role: String, val content: String, val isPartial: Boolean = false)

class ChatUiState(
    val messages: List<UiMessage> = emptyList(),
    val streaming: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repo: ChatRepository,
    private val securePrefs: com.akitik.aiza.data.security.SecurePrefs
) : ViewModel() {

    private val _state = MutableStateFlow(ChatUiState())
    val state: StateFlow<ChatUiState> = _state.asStateFlow()

    private var currentPartialIndex: Int? = null

    fun sendMessage(text: String, model: String = "gpt-4o-mini") {
        val apiKey = securePrefs.getApiKey() ?: return
        viewModelScope.launch {
            // append user message
            val userUi = UiMessage("user", text)
            _state.update { it.copy(messages = it.messages + userUi, error = null) }

            // prepare messages
            val messages = listOf(ChatMessagePayload(role = "user", content = text))
            _state.update { it.copy(streaming = true) }

            // stream tokens
            repo.streamMessage(apiKey, model, messages)
                .onEach { chunk ->
                    // update last partial assistant message or append new one
                    val cur = _state.value.messages.toMutableList()
                    val last = cur.lastOrNull()
                    if (last?.role == "assistant" && last.isPartial) {
                        // replace
                        cur[cur.lastIndex] = last.copy(content = last.content + chunk)
                    } else {
                        cur.add(UiMessage("assistant", chunk, isPartial = true))
                    }
                    _state.update { it.copy(messages = cur) }
                }
                .catch { e ->
                    _state.update { it.copy(error = e.localizedMessage ?: "stream error", streaming = false) }
                }
                .collect {
                    // collection handled in onEach. When stream completes we mark final
                }

            // after stream completes
            _state.update { s ->
                val finalized = s.messages.map { if (it.isPartial && it.role == "assistant") it.copy(isPartial = false) else it }
                s.copy(messages = finalized, streaming = false)
            }
        }
    }
}
