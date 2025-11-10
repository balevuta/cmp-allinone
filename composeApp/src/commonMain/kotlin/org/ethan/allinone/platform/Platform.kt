package org.ethan.allinone.platform

import app.cash.sqldelight.db.SqlDriver
import io.ktor.client.engine.HttpClientEngine
import kotlinx.coroutines.CoroutineDispatcher

interface Platform {
    val name: String
    val clientEngine: HttpClientEngine
    val coroutineDispatcher: CoroutineDispatcher
}

expect fun getPlatform(): Platform

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}