package com.example.beetlinkapp.models.repository

import com.example.beetlinkapp.models.entity.token.Token

interface TokenRepository {
    fun getTokenByUserId(userId: Long): Token?
    fun removeTokenByUserId(userId: Long)
}