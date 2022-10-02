package com.leandroid.system.mygymroutines.di.repository

import com.leandroid.system.mygymroutines.data.repository.days.monday.*
import org.koin.dsl.module

val repositoryModule = module {
    single<MondayRepository> { MondayRepositoryImpl() }
}


