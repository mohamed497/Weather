package com.mohamed.gamal.data.repository.weather

import com.mohamed.gamal.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherRemote {
    fun getWeather(): Observable<WeatherResponse>

}