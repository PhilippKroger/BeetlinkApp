package com.example.beetlinkapp.models.entity.user

enum class Role(
    private val value: String
) {
    ADMIN("ADMIN"),
    PREMIUM_USER("PREMIUM_USER"),
    USER("USER");

    fun getAuthority() = value
}