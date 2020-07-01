package ru.skillbranch.sbdelivery.data.common.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class BaseErrorResponseBody(

//    @SerializedName("apiVersion")
//    val apiVersion: String? = null,

    @SerializedName("error")
    val isError: String? = null,
//
//    @SerializedName("id")
//    val errorId: Int? = null,

    @SerializedName("code")
    val errorCode: String? = null,

    @SerializedName("message")
    val errorMessage: String? = null
//
//    @SerializedName("data")
//    val errorBody: String? = null

)