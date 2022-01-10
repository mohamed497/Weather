package com.mohamed.gamal.remote.di

import com.mohamed.gamal.data.repository.weather.WeatherRemote
import com.mohamed.gamal.domain.repository.WeatherRepository
import com.mohamed.gamal.remote.WeatherRemoteImpl
import com.mohamed.gamal.remote.client.RetrofitClient
import com.mohamed.gamal.remote.mappers.weather.WeatherModelMapper
import com.mohamed.gamal.remote.mappers.weather.WeatherResponseModelMapper
import com.mohamed.gamal.remote.service.WeatherApiService
import org.koin.dsl.module
import retrofit2.Retrofit



val remoteModule = module {


    single<Retrofit> { RetrofitClient.createRetrofitInstance() }
    single<WeatherApiService> {
        RetrofitClient.createServiceClass(
            get(),
            WeatherApiService::class.java
        )
    }
    factory { WeatherResponseModelMapper(get()) }
    factory { WeatherModelMapper() }

    single<WeatherRemote> { WeatherRemoteImpl(weatherService = get(), weatherMapper = get()) }


}