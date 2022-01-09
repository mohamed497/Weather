package com.mohamed.gamal.weather.view.application

import android.app.Application
import com.mohamed.gamal.data.di.dataModule
import com.mohamed.gamal.domain.di.domainModule
import com.mohamed.gamal.presentation2.di.presentationModule
import com.mohamed.gamal.remote.di.remoteModule
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
                    presentationModule,
                    domainModule,
                    dataModule,
                    remoteModule
                )
            )
        }
    }
}