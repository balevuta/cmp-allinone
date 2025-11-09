package org.ethan.allinone.core.di

import org.ethan.allinone.domain.usecase.GetProductsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductsUseCase(get()) }
}

