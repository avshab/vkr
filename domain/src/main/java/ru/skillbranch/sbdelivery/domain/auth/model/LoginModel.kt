package ru.skillbranch.sbdelivery.domain.auth.model

data class LoginModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val accessToken: String,
    val refreshToken: String
)