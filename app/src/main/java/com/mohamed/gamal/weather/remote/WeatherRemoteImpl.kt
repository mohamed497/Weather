package com.mohamed.gamal.weather.remote

import com.mohamed.gamal.weather.data.repository.weather.WeatherRemote
import com.mohamed.gamal.weather.domain.models.WeatherResponse
import com.mohamed.gamal.weather.remote.service.WeatherApiService
import io.reactivex.rxjava3.core.Observable

class WeatherRemoteImpl(private val weatherService : WeatherApiService): WeatherRemote {
    override fun getWeather(): Observable<WeatherResponse> {
        return weatherService.getWeather()
    }
}