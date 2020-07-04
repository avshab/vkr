package ru.skillbranch.sbdelivery.data.profile.api

import com.google.gson.annotations.SerializedName

class ProfileResponseBody(

    @SerializedName("id")
    val id: String,

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("email")
    val email: String
)