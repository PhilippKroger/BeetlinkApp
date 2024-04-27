package com.example.beetlinkapp.models.entity.link

import com.example.beetlinkapp.models.entity.AbstractEntity
import com.example.beetlinkapp.models.entity.user.User

class Link(
    var user: User,
    var iosUrl: String?,
    var androidUrl: String?,
    var desktopUrl: String?,
    var defaultUrl: String,
    var description: String?,
    var shortId: String?,
    var statistics: MutableList<LinkStatistic> = mutableListOf()

): AbstractEntity() {
}