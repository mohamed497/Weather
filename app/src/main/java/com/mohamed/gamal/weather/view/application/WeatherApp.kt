package com.mohamed.gamal.weather.view.application

import android.app.Application
import com.mohamed.gamal.weather.presentation.di.*
import com.mohamed.gamal.weather.remote.di.networkKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()

    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@WeatherApp)
            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    repositoryModule,
                    networkKoinModule,
                    weatherRepositoryImplModule,
                    weatherDataSourceFactory,
                    weatherRemoteDataStore,
                    weatherRemoteImpl

                )
            )
        }
    }
}