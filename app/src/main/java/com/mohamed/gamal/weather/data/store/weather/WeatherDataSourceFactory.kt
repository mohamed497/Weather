package com.mohamed.gamal.weather.data.store.weather

import com.mohamed.gamal.weather.data.repository.weather.WeatherDataStore

class WeatherDataSourceFactory(private val weatherRemoteDataStore: WeatherRemoteDataStore) {
    fun getRemote():WeatherDataStore = weatherRemoteDataStore
}