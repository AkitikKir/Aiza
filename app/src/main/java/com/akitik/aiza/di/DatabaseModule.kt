package com.akitik.aiza.di

import android.content.Context
import androidx.room.Room
import com.example.openrouter.data.db.ChatDatabase
import com.example.openrouter.data.db.ChatDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDb(@ApplicationContext app: Context): ChatDatabase {
        return Room.databaseBuilder(app, ChatDatabase::class.java, "chat-db").build()
    }

    @Provides
    fun provideChatDao(db: ChatDatabase): ChatDao = db.chatDao()
}
