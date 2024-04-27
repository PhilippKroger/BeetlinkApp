package com.example.beetlinkapp.models.dto.response.link

import java.time.LocalDateTime

data class LinkStatisticInfo (
    val createdAt: LocalDateTime,
    val ipAddress: String,
    val language: String,
    val deviceType: String,
    val referer: String
)
