package com.mohamed.gamal.domain.usecases.weather

import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.repository.WeatherRepository

open class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun createWeatherResponse(): WeatherResponse {
        return weatherRepository.getWeather()
    }
}