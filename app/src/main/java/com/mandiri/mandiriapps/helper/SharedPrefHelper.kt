package com.mandiri.mandiriapps.helper

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

//    private val sharedPreferences: SharedPreferences =
//        context.getSharedPreferences(TOKEN_KEY, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString(TOKEN_KEY, null) ?: ""
    }

    fun clearDataPref() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
//        private const val SHARED_PREF = "mypref"
        private const val TOKEN_KEY = "token_key"
    }
}
