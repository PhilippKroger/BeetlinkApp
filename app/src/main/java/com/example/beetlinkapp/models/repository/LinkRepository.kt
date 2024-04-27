package com.example.beetlinkapp.models.repository

import com.example.beetlinkapp.models.entity.link.Link

interface LinkRepository {
    fun getLinkById(id: Long): Link?
    fun getLinkByShortId(shortId: String): Link?
    fun removeLinkById(id: Long)
}