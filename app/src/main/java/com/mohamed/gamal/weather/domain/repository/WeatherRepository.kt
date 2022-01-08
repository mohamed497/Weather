package com.mohamed.gamal.weather.domain.repository

import com.mohamed.gamal.weather.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherRepository {
    fun getWeather(): Observable<WeatherResponse>
}