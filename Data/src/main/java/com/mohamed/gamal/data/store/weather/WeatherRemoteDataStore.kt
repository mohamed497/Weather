package com.mohamed.gamal.data.store.weather

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.data.repository.weather.WeatherDataStore
import com.mohamed.gamal.data.repository.weather.WeatherRemote
import com.mohamed.gamal.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable

open class WeatherRemoteDataStore(private val weatherRemote: WeatherRemote) : WeatherDataStore {

    override fun getWeather(): Observable<WeatherResponseEntity> {
        return weatherRemote.getWeather()
    }

}