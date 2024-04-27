package com.example.beetlinkapp.models.entity.token

import com.example.beetlinkapp.models.entity.AbstractEntity

class Token(
    val userId: Long,
    val accessToken: String,
    val refreshToken: String
): AbstractEntity() {
}