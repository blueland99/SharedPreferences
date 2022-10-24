package com.blueland.sharedpreferences.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class PreferenceManager(private val context: Context) {

    private val TAG = javaClass.simpleName

    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor
    private val fileName by lazy { "${context.packageName}.preference" }

    init {
        // SharedPreference 암호화를 위한 masterKey 생성
        val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        preferences = EncryptedSharedPreferences.create(
            context,
            fileName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        editor = preferences.edit()
    }

    fun put(key: String, value: String) {
        Log.d(TAG, "put: key=$key, value=$value, type=${value.javaClass.simpleName}")
        editor.putString(key, value).commit()
    }


    fun put(key: String, value: Set<String>) {
        Log.d(TAG, "put: key=$key, value=$value, type=${value.javaClass.simpleName}")
        editor.putStringSet(key, value).commit()
    }

    fun put(key: String, value: Int) {
        Log.d(TAG, "put: key=$key, value=$value, type=${value.javaClass.simpleName}")
        editor.putInt(key, value).commit()
    }

    fun put(key: String, value: Long) {
        Log.d(TAG, "put: key=$key, value=$value, type=${value.javaClass.simpleName}")
        editor.putLong(key, value).commit()
    }

    fun put(key: String, value: Float) {
        Log.d(TAG, "put: key=$key, value=$value, type=${value.javaClass.simpleName}")
        editor.putFloat(key, value).commit()
    }

    fun put(key: String, value: Boolean) {
        Log.d(TAG, "put: key=$key, value=$value, type=${value.javaClass.simpleName}")
        editor.putBoolean(key, value).commit()
    }

    fun getString(key: String): String {
        val value = preferences.getString(key, null) ?: ""
        Log.d(TAG, "getString: key=$key, value=$value")
        return value
    }

    fun getStringSet(key: String): Set<String> {
        val value = preferences.getStringSet(key, null) ?: setOf()
        Log.d(TAG, "getStringSet: key=$key, value=$value")
        return value
    }

    fun getInt(key: String): Int {
        val value = preferences.getInt(key, 0)
        Log.d(TAG, "getInt: key=$key, value=$value")
        return value
    }

    fun getLong(key: String): Long {
        val value = preferences.getLong(key, 0)
        Log.d(TAG, "getLong: key=$key, value=$value")
        return value
    }

    fun getFloat(key: String): Float {
        val value = preferences.getFloat(key, 0f)
        Log.d(TAG, "getFloat: key=$key, value=$value")
        return value
    }

    fun getBoolean(key: String): Boolean {
        val value = preferences.getBoolean(key, false)
        Log.d(TAG, "getBoolean: key=$key, value=$value")
        return value
    }

    fun delete(key: String) {
        Log.d(TAG, "delete: key=$key")
        editor.remove(key).commit()
    }
}