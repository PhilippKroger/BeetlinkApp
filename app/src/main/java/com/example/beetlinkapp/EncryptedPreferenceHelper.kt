package com.example.beetlinkapp

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys


object EncryptedPreferenceHelper {

    private const val PREF_NAME = "my_encrypted_prefs"
    private lateinit var encryptedSharedPreferences: SharedPreferences

    fun init(context: Context) {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        encryptedSharedPreferences = EncryptedSharedPreferences.create(
            PREF_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun putString(key: String, value: String) {
        encryptedSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String?): String? {
        return encryptedSharedPreferences.getString(key, defaultValue)
    }

    fun contains(key: String): Boolean {
        return encryptedSharedPreferences.contains(key)
    }

    fun remove(key: String) {
        encryptedSharedPreferences.edit().remove(key).apply()
    }
}