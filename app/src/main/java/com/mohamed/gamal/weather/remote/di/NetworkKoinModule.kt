package com.mohamed.gamal.weather.remote.di

import com.mohamed.gamal.weather.remote.client.RetrofitClient
import com.mohamed.gamal.weather.remote.service.WeatherApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val networkKoinModule = module {
    single<Retrofit> { RetrofitClient.createRetrofitInstance() }
    single<WeatherApiService> {
        RetrofitClient.createServiceClass(
            get(),
            WeatherApiService::class.java
        )
    }

}