package org.ethan.allinone.core.di

fun appModule() = listOf(
    networkModule,
    apiServiceModule,
    remoteDataSourceModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)