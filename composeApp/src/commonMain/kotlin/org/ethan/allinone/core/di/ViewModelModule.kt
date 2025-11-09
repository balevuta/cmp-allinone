package org.ethan.allinone.core.di

import org.ethan.allinone.presentation.viewmodel.HomeViewModel
import org.ethan.allinone.presentation.viewmodel.ProductsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { HomeViewModel(get()) }
    factory { ProductsViewModel(get()) }
}


