//package com.example.gymapp.auth
//
//import android.content.SharedPreferences
//import javax.inject.Inject
//
//class TokenManager @Inject constructor(private val sharedPreferences: SharedPreferences) {
//
//    companion object {
//        private const val TOKEN_KEY = "token"
//    }
//
//    fun saveToken(token: String) {
//        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
//    }
//
//    fun getToken(): String? {
//        return sharedPreferences.getString(TOKEN_KEY, null)
//    }
//}