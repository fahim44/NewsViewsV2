package com.fahim.backendlib.di

import com.fahim.backendlib.datasource.base.SharedPreferenceDataSource
import com.fahim.backendlib.datasource.impl.SharedPreferenceDataSourceImpl
import com.fahim.backendlib.repository.base.AppRepository
import com.fahim.backendlib.repository.impl.AppRepositoryImpl
import org.koin.dsl.module

object BackendlibKoinModule {
    @JvmField
    val appRepositoryModule = module {
        single<SharedPreferenceDataSource> { SharedPreferenceDataSourceImpl(get()) }
        single<AppRepository> { AppRepositoryImpl(get()) }
    }
}
