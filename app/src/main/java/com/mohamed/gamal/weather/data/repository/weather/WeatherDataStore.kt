package com.mohamed.gamal.weather.data.repository.weather

import com.mohamed.gamal.weather.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherDataStore {

    fun getWeather(): Observable<WeatherResponse>
}