package com.leandroid.system.mygymroutines

import android.app.Application
import com.leandroid.system.mygymroutines.di.repository.repositoryModule
import com.leandroid.system.mygymroutines.di.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyGymRoutinesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyGymRoutinesApplication)
            koin.loadModules(
                listOf(
//                    utilsModule,
//                    networkModule,
//                    dbModule,
//                    dataSourceModule,
                    repositoryModule,
                    viewModelModule

                )
            )
            // koin.createRootScope()
        }
    }
}