package com.d2brothers.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform