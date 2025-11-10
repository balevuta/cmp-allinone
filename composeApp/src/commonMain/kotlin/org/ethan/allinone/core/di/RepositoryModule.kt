package org.ethan.allinone.core.di

import org.ethan.allinone.data.reposittory.HomeRepository
import org.ethan.allinone.data.reposittory.ProductRepositoryImpl
import org.ethan.allinone.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { HomeRepository(get()) }
    factory<ProductRepository> {
        ProductRepositoryImpl(
            remoteDataSource = get(),
            localDataSource = get()
        )
    }
}