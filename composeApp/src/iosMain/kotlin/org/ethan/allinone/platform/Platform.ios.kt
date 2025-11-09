package org.ethan.allinone.platform

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val clientEngine: HttpClientEngine = Darwin.create()
    override val coroutineDispatcher = Dispatchers.IO
}

actual fun getPlatform(): Platform = IOSPlatform()