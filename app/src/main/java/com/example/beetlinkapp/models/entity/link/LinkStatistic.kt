package com.example.beetlinkapp.models.entity.link

import com.example.beetlinkapp.models.entity.AbstractEntity

class LinkStatistic(
    var link: Link,
    var ipAddress: String,
    var language: String,
    var deviceType: String,
    var referer: String
): AbstractEntity() {
}