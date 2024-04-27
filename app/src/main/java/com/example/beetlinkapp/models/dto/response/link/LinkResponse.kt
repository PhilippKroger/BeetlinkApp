package com.example.beetlinkapp.models.dto.response.link

import java.time.LocalDateTime

data class LinkInfo(
    val id: Long,
    val iosUrl: String?,
    val androidUrl: String?,
    val desktopUrl: String?,
    val defaultUrl: String,
    val shortUrl: String,
    val description: String?,
    val createdAt: LocalDateTime
)