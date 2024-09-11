package org.ethan.allinone.platform

import io.ktor.client.engine.HttpClientEngine

interface Platform {
    val name: String
    val clientEngine: HttpClientEngine
}

expect fun getPlatform(): Platform