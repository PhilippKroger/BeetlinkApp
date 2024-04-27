package com.example.beetlinkapp.models.dto.response.auth

data class AuthTokenInfo(
    val refreshToken: String,
    val accessToken: String,
    val registration: Boolean
)
