package com.akitik.aiza.data.repository;

import com.akitik.aiza.data.api.OpenRouterApi;
import com.akitik.aiza.data.api.StreamWebSocketClient;
import com.akitik.aiza.data.db.ChatDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ChatRepositoryImpl_Factory implements Factory<ChatRepositoryImpl> {
  private final Provider<OpenRouterApi> apiProvider;

  private final Provider<StreamWebSocketClient> wsClientProvider;

  private final Provider<ChatDao> daoProvider;

  public ChatRepositoryImpl_Factory(Provider<OpenRouterApi> apiProvider,
      Provider<StreamWebSocketClient> wsClientProvider, Provider<ChatDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.wsClientProvider = wsClientProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public ChatRepositoryImpl get() {
    return newInstance(apiProvider.get(), wsClientProvider.get(), daoProvider.get());
  }

  public static ChatRepositoryImpl_Factory create(Provider<OpenRouterApi> apiProvider,
      Provider<StreamWebSocketClient> wsClientProvider, Provider<ChatDao> daoProvider) {
    return new ChatRepositoryImpl_Factory(apiProvider, wsClientProvider, daoProvider);
  }

  public static ChatRepositoryImpl newInstance(OpenRouterApi api, StreamWebSocketClient wsClient,
      ChatDao dao) {
    return new ChatRepositoryImpl(api, wsClient, dao);
  }
}
