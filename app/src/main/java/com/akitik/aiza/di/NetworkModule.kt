package com.akitik.aiza.di

import android.content.Context
import com.example.openrouter.data.api.OpenRouterApi
import com.example.openrouter.data.api.StreamWebSocketClient
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.text.Charsets.UTF_8
import okhttp3.MediaType.Companion.toMediaType


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideJson(): Json = Json { ignoreUnknownKeys = true; encodeDefaults = true }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // in debug only in production -> NONE
        }

        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val req = chain.request().newBuilder()
                    // do not log secrets
                    .build()
                chain.proceed(req)
            }
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(0, TimeUnit.SECONDS) // streaming can be long-lived
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, json: Json): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.OPENROUTER_BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenRouterApi(retrofit: Retrofit): OpenRouterApi =
        retrofit.create(OpenRouterApi::class.java)

    @Provides
    @Singleton
    fun provideWebSocketClient(client: OkHttpClient): StreamWebSocketClient =
        StreamWebSocketClient(client, BuildConfig.OPENROUTER_BASE_URL)
}
