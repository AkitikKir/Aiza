package com.akitik.aiza.di;

import android.content.Context;
import androidx.room.Room;
import com.example.openrouter.data.db.ChatDatabase;
import com.example.openrouter.data.db.ChatDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/akitik/aiza/di/DatabaseModule;", "", "()V", "provideChatDao", "error/NonExistentClass", "db", "(Lerror/NonExistentClass;)Lerror/NonExistentClass;", "provideDb", "app", "Landroid/content/Context;", "(Landroid/content/Context;)Lerror/NonExistentClass;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.akitik.aiza.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final ChatDatabase provideDb(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context app) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final ChatDao provideChatDao(@org.jetbrains.annotations.NotNull()
    ChatDatabase db) {
        return null;
    }
}