package com.example.beetlinkapp.models.dto.request.link

data class LinkRequest(
    val iosUrl: String?,
    val androidUrl: String?,
    val desktopUrl: String?,
    val defaultUrl: String,
    val description: String?
)