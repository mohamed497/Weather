package com.mohamed.gamal.weather.remote

import com.mohamed.gamal.weather.domain.models.WeatherResponse
import com.mohamed.gamal.weather.remote.service.WeatherApiService
import com.mohamed.gamal.weather.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable

class WeatherRemoteRepository(private val weatherService: WeatherApiService): WeatherRepository {
    override fun getWeather(): Observable<WeatherResponse> {
        return weatherService.getWeather()
    }
}