package com.mohamed.gamal.remote

import com.mohamed.gamal.remote.service.WeatherApiService
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.repository.WeatherRepository
import com.mohamed.gamal.remote.mappers.weather.WeatherResponseModelMapper
import io.reactivex.rxjava3.core.Observable

class WeatherRemoteRepository(
    private val weatherService: WeatherApiService,
) : WeatherRepository {
    override fun getWeather(): Observable<WeatherResponse> {
        return weatherService.getWeather()
    }
}