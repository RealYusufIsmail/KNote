package io.github.realyusufismail.knote

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform