package ru.skillbranch.sbdelivery.data.auth.model

/**
 * Created by Anna Shabaeva on 28.06.2020
 */
class LoginResultResponseBody(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val accessToken: String,
    val refreshToken: String
)

