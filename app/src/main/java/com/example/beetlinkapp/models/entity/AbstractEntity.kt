package com.example.beetlinkapp.models.entity

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDateTime

abstract class AbstractEntity: Serializable {
    val id: Long = 0
    @RequiresApi(Build.VERSION_CODES.O)
    val createdAt: LocalDateTime = LocalDateTime.now()
}