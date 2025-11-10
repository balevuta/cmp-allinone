package org.ethan.allinone.core.di

import org.ethan.allinone.platform.DatabaseDriverFactory
import org.koin.dsl.module

actual val platformModule = module {
    factory<DatabaseDriverFactory> {
        DatabaseDriverFactory()
    }
}

