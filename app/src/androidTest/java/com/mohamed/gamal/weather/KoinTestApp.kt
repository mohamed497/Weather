package com.mohamed.gamal.weather

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class KoinTestApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {  }
    }

    override fun onTerminate() {
        stopKoin()
        super.onTerminate()
    }
}