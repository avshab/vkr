package ru.skillbranch.sbdelivery.data.auth.api

import com.google.gson.annotations.SerializedName

class RegisterRequestBody(

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String
)