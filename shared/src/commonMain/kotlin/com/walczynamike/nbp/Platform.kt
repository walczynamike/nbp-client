package com.walczynamike.nbp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform