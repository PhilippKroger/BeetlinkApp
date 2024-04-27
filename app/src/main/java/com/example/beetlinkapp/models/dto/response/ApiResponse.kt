package com.example.beetlinkapp.models.dto.response

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpStatus
import java.time.LocalDateTime

interface ApiResponse {
    val status: HttpStatus
    val message: String
    val timestamp: LocalDateTime


}