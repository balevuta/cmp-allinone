package org.ethan.allinone.di

fun appModule() = listOf(
    networkModule, repositoryModule, viewModelModule, apiServiceModule,
    remoteDataSourceModule
)