package ru.skillbranch.sbdelivery.data.auth.api

import com.google.gson.annotations.SerializedName

class RefreshAuthRequestBody(
    @SerializedName("refreshToken")
    val refreshToken: String

)