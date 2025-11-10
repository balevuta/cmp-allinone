package org.ethan.allinone.core.di

import org.ethan.allinone.data.local.LocalDataSource
import org.ethan.allinone.data.local.ProductDatabase
import org.ethan.allinone.platform.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single {
        val driverFactory: DatabaseDriverFactory = get()
        val driver = driverFactory.createDriver()
        ProductDatabase(driver)
    }
    single { LocalDataSource(get()) }
}

