package org.ethan.allinone.core.di

fun appModule() = listOf(
    platformModule,
    networkModule,
    databaseModule,
    apiServiceModule,
    remoteDataSourceModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)