package ru.skillbranch.sbdelivery.data.auth.api

import com.google.gson.annotations.SerializedName

class RecoveryPasswordBody(

    @SerializedName("email")
    val email: String,

    @SerializedName("code")
    val code: String,

    @SerializedName("password")
    val password: String
)

