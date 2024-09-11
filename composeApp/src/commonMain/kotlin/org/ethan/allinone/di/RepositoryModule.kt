package org.ethan.allinone.di

import org.ethan.allinone.data.reposittory.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { HomeRepository(get()) }
}