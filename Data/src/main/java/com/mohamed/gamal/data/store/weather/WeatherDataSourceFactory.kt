package com.mohamed.gamal.data.store.weather

import com.mohamed.gamal.data.repository.weather.WeatherDataStore

class WeatherDataSourceFactory(private val weatherRemoteDataStore: WeatherRemoteDataStore) {
    fun getRemote(): WeatherDataStore = weatherRemoteDataStore
}