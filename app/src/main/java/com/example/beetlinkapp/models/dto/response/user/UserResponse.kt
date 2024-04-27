package com.example.beetlinkapp.models.dto.response.user

import com.example.beetlinkapp.models.entity.user.Role

data class UserInfo(
    val id: Long,
    val email: String,
    val role: Role,
    val self: Boolean
)
