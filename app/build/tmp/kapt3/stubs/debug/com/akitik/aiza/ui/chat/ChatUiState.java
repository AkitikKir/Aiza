package com.akitik.aiza.ui.chat;

import androidx.lifecycle.ViewModel;
import com.akitik.aiza.data.api.ChatMessagePayload;
import com.akitik.aiza.data.api.ChatCompletionRequest;
import com.akitik.aiza.data.repository.ChatRepository;
import com.akitik.aiza.data.db.entities.ChatMessage;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/akitik/aiza/ui/chat/ChatUiState;", "", "messages", "", "Lcom/akitik/aiza/ui/chat/UiMessage;", "streaming", "", "error", "", "(Ljava/util/List;ZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "getMessages", "()Ljava/util/List;", "getStreaming", "()Z", "app_debug"})
public final class ChatUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.akitik.aiza.ui.chat.UiMessage> messages = null;
    private final boolean streaming = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    
    public ChatUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.akitik.aiza.ui.chat.UiMessage> messages, boolean streaming, @org.jetbrains.annotations.Nullable()
    java.lang.String error) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.akitik.aiza.ui.chat.UiMessage> getMessages() {
        return null;
    }
    
    public final boolean getStreaming() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public ChatUiState() {
        super();
    }
}