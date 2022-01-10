package com.mohamed.gamal.data.repository.weather

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherDataStore {

//    fun getWeather(): Observable<WeatherResponse>
    fun getWeather(): Observable<WeatherResponseEntity>
}