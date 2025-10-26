package com.akitik.aiza.data.security

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class SecurePrefs(context: Context) {
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val prefs = EncryptedSharedPreferences.create(
        context,
        "secure_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun setApiKey(apiKey: String) {
        prefs.edit().putString("openrouter_api_key", apiKey).apply()
    }

    fun getApiKey(): String? = prefs.getString("openrouter_api_key", null)

    fun clear() {
        prefs.edit().clear().apply()
    }
}
