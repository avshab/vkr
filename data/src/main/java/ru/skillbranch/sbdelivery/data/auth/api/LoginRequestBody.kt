package ru.skillbranch.sbdelivery.data.auth.api

import com.google.gson.annotations.SerializedName

class LoginRequestBody(

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String
)