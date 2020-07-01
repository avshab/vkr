package ru.skillbranch.sbdelivery.domain.auth.login

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

data class LoginModel(
    val accessToken: String,
    val refreshToken: String
)