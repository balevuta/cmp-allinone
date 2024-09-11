package org.ethan.allinone

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val clientEngine: HttpClientEngine = OkHttp.create()
}

actual fun getPlatform(): Platform = WasmPlatform()