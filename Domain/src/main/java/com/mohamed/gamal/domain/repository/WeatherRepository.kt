package com.mohamed.gamal.domain.repository

import com.mohamed.gamal.domain.models.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(): WeatherResponse
}