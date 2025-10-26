package com.akitik.aiza.di;

import com.example.openrouter.data.api.OpenRouterApi;
import com.example.openrouter.data.repository.ChatRepository;
import com.example.openrouter.data.repository.ChatRepositoryImpl;
import com.example.openrouter.data.db.ChatDao;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\'\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/akitik/aiza/di/DataModule;", "", "()V", "bindChatRepository", "error/NonExistentClass", "impl", "(Lerror/NonExistentClass;)Lerror/NonExistentClass;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class DataModule {
    
    public DataModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract ChatRepository bindChatRepository(@org.jetbrains.annotations.NotNull()
    ChatRepositoryImpl impl);
}