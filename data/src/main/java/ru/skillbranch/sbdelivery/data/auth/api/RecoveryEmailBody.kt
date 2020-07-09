package ru.skillbranch.sbdelivery.data.auth.api

import com.google.gson.annotations.SerializedName

class RecoveryEmailBody(

    @SerializedName("email")
    val email: String
)