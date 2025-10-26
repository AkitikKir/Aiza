package com.akitik.aiza.ui.chat;

import com.akitik.aiza.data.repository.ChatRepository;
import com.akitik.aiza.data.security.SecurePrefs;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ChatViewModel_Factory implements Factory<ChatViewModel> {
  private final Provider<ChatRepository> repoProvider;

  private final Provider<SecurePrefs> securePrefsProvider;

  public ChatViewModel_Factory(Provider<ChatRepository> repoProvider,
      Provider<SecurePrefs> securePrefsProvider) {
    this.repoProvider = repoProvider;
    this.securePrefsProvider = securePrefsProvider;
  }

  @Override
  public ChatViewModel get() {
    return newInstance(repoProvider.get(), securePrefsProvider.get());
  }

  public static ChatViewModel_Factory create(Provider<ChatRepository> repoProvider,
      Provider<SecurePrefs> securePrefsProvider) {
    return new ChatViewModel_Factory(repoProvider, securePrefsProvider);
  }

  public static ChatViewModel newInstance(ChatRepository repo, SecurePrefs securePrefs) {
    return new ChatViewModel(repo, securePrefs);
  }
}
