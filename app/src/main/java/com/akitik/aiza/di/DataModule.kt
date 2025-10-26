package com.akitik.aiza.di

import com.example.openrouter.data.api.OpenRouterApi
import com.example.openrouter.data.repository.ChatRepository
import com.example.openrouter.data.repository.ChatRepositoryImpl
import com.example.openrouter.data.db.ChatDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindChatRepository(impl: ChatRepositoryImpl): ChatRepository
}
