package org.ethan.allinone.di

import org.ethan.allinone.data.remote.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}
