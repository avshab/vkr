package ru.skillbranch.sbdelivery.domain.auth.model

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

data class AuthModel(
    val accessToken: String,
    val refreshToken: String
) {

    //TODO
    companion object {
        val EMPTY =
            AuthModel("", "")
    }

    val isNotEmpty: Boolean
        get() = accessToken.isNotBlank() && refreshToken.isNotBlank()

}