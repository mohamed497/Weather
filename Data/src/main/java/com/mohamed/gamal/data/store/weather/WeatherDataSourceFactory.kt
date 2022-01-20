package com.mohamed.gamal.data.store.weather

import com.mohamed.gamal.data.repository.weather.WeatherDataStore

open class WeatherDataSourceFactory(private val weatherRemoteDataStore: WeatherRemoteDataStore) {
    open suspend fun getRemote(): WeatherDataStore = weatherRemoteDataStore
}