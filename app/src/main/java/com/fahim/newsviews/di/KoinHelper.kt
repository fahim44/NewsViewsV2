package com.fahim.newsviews.di

import android.app.Application
import com.fahim.backendlib.di.BackendlibKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object KoinHelper {
    @JvmStatic
    fun start(application: Application) {
        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(application)
            // use modules
            modules(listOf(BackendlibKoinModule.appRepositoryModule))
        }
    }
}