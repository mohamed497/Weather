package com.mohamed.gamal.data.di

import com.mohamed.gamal.data.WeatherRepositoryImpl
import com.mohamed.gamal.data.mappers.weather.WeatherEntityMapper
import com.mohamed.gamal.data.mappers.weather.WeatherResponseEntityMapper
import com.mohamed.gamal.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.data.store.weather.WeatherRemoteDataStore
import com.mohamed.gamal.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    factory { WeatherEntityMapper() }
    factory { WeatherResponseEntityMapper(get()) }

    single { WeatherDataSourceFactory(weatherRemoteDataStore = get()) }
    single { WeatherRemoteDataStore(weatherRemote = get()) }

    single<WeatherRepository> {
        WeatherRepositoryImpl(
            weatherDataSourceFactory = get(),
            weatherMapper = get()
        )
    }

}