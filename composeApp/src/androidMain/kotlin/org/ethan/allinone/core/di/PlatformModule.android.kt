package org.ethan.allinone.core.di

import android.content.Context
import org.ethan.allinone.AppContextHolder
import org.ethan.allinone.platform.DatabaseDriverFactory
import org.koin.dsl.module

actual val platformModule = module {
    single<DatabaseDriverFactory> {
        val context: Context = AppContextHolder.appContext
            ?: throw IllegalStateException("AppContext not initialized. Make sure MainActivity.onCreate() is called first.")
        DatabaseDriverFactory(context)
    }
}
