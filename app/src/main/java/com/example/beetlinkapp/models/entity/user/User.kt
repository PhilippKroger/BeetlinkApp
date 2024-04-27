package com.example.beetlinkapp.models.entity.user

import com.example.beetlinkapp.models.entity.AbstractEntity
import com.example.beetlinkapp.models.entity.link.Link

class User(
    val email: String,
    val password: String,
    val links: MutableList<Link> = mutableListOf()
): AbstractEntity() {
    fun addLink(link: Link) {
        links.add(link)
        link.user = this
    }
}