package com.example.beetlinkapp.models.dto.request.link

data class LinkStatisticRequest(
    val linkId: Long,
    val ipAddress: String,
    val language: String?,
    val deviceType: String?,
    val referer: String?
)
