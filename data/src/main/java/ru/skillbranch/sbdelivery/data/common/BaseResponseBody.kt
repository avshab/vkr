package ru.skillbranch.sbdelivery.data.common

import com.google.gson.annotations.SerializedName

/**
 * Created by Anna Shabaeva on 07.06.2020
 */
//TODO not used
open class BaseResponseBody {

    @SerializedName("apiVersion")
    val apiVersion: String? = null

    @SerializedName("error")
    val isError: Boolean? = false

    @SerializedName("code")
    val errorCode: String? = null

    @SerializedName("message")
    val message: String? = null

}