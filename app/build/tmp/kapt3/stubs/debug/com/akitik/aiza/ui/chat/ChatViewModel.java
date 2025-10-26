package com.akitik.aiza.ui.chat;

import androidx.lifecycle.ViewModel;
import com.akitik.aiza.data.api.ChatMessagePayload;
import com.akitik.aiza.data.api.ChatCompletionRequest;
import com.akitik.aiza.data.repository.ChatRepository;
import com.akitik.aiza.data.db.entities.ChatMessage;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/akitik/aiza/ui/chat/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/akitik/aiza/data/repository/ChatRepository;", "securePrefs", "Lcom/akitik/aiza/data/security/SecurePrefs;", "(Lcom/akitik/aiza/data/repository/ChatRepository;Lcom/akitik/aiza/data/security/SecurePrefs;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/akitik/aiza/ui/chat/ChatUiState;", "currentPartialIndex", "", "Ljava/lang/Integer;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "sendMessage", "", "text", "", "model", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.akitik.aiza.data.repository.ChatRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.akitik.aiza.data.security.SecurePrefs securePrefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.akitik.aiza.ui.chat.ChatUiState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.akitik.aiza.ui.chat.ChatUiState> state = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer currentPartialIndex;
    
    @javax.inject.Inject()
    public ChatViewModel(@org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.repository.ChatRepository repo, @org.jetbrains.annotations.NotNull()
    com.akitik.aiza.data.security.SecurePrefs securePrefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.akitik.aiza.ui.chat.ChatUiState> getState() {
        return null;
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String model) {
    }
}