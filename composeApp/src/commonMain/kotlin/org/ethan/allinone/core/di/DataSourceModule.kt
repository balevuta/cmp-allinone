package org.ethan.allinone.core.di

import org.ethan.allinone.data.remote.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}
