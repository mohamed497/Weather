package com.mohamed.gamal.domain.repository

import com.mohamed.gamal.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherRepository {
    fun getWeather(): Observable<WeatherResponse>
}