package ru.skillbranch.sbdelivery.data.common.api

import com.google.gson.annotations.SerializedName

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

open class BaseResponseBody {

    @SerializedName("error")
    val isError: Boolean? = false

    @SerializedName("code")
    val errorCode: String? = null

    @SerializedName("message")
    val message: String? = null

}