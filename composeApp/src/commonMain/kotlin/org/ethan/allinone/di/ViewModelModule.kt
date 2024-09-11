package org.ethan.allinone.di

import org.ethan.allinone.viewmodel.HomeViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { HomeViewModel(get()) }
}


