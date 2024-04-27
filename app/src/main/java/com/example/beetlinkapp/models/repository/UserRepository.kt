package com.example.beetlinkapp.models.repository

import com.example.beetlinkapp.models.entity.user.User

interface UserRepository {
    fun existsByEmail(email: String): Boolean
    fun getUserById(id: Long): User?
    fun getUserByEmail(email: String): User?
    fun removeUserById(id: Long)
}