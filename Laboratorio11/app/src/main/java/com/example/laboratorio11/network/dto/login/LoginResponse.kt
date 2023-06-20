package com.example.laboratorio11.network.dto.login

import com.example.laboratorio11.ui.register.RegisterUiStatus
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("msg") val message: String,
    @SerializedName("token") val token: String,
)