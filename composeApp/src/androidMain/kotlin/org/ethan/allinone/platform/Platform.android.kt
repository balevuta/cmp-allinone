package org.ethan.allinone.platform

import android.os.Build
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val clientEngine: HttpClientEngine = OkHttp.create()
}

actual fun getPlatform(): Platform = AndroidPlatform()