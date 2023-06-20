package com.example.laboratorio11

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.laboratorio11.network.retrofit.RetrofitInstance
import com.example.laboratorio11.network.service.AuthService
import com.example.laboratorio11.repository.CredentialsRepository

class RetrofitApplication : Application() {

    // TODO: Create a variable to store the token in the SharedPreference
    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }

    // TODO: Get the API service from the Retrofit instance and set the token

    private fun getAPIService()= with(RetrofitInstance){
        setToken(getToken())
        getLoginService()
    }
    // TODO: Create a function to get the token

    fun getToken(): String = prefs.getString(USER_TOKEN,"")!!
    // TODO: Initialize the repository

    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }

    // TODO: Create a function to save the token in the SharedPreferences

    fun saveAuthToken(token: String){
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    companion object {
        const val USER_TOKEN = "user_token"
    }
}