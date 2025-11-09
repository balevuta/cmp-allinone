package org.ethan.allinone.platform

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.Dispatchers

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val clientEngine: HttpClientEngine = OkHttp.create()
    override val coroutineDispatcher = Dispatchers.IO
}

actual fun getPlatform(): Platform = JVMPlatform()