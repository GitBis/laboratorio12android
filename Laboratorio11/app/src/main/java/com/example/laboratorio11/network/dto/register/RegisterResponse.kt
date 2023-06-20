package com.example.laboratorio11.network.dto.register

import com.example.laboratorio11.ui.register.RegisterUiStatus
import com.google.gson.annotations.SerializedName


data class RegisterResponse (
    @SerializedName("msg") val message: String
        )