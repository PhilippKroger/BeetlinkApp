package com.example.beetlinkapp.models.dto.request.auth

data class PasswordRequest(
    val oldPassword: String,
    val newPassword: String
)
