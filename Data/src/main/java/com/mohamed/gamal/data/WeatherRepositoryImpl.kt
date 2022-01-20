package com.mohamed.gamal.data

import com.mohamed.gamal.data.mappers.weather.WeatherResponseEntityMapper
import com.mohamed.gamal.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.repository.WeatherRepository

open class WeatherRepositoryImpl(
    private val weatherDataSourceFactory: WeatherDataSourceFactory,
    private val weatherMapper: WeatherResponseEntityMapper
) : WeatherRepository {
    override suspend fun getWeather(): WeatherResponse {
        return weatherDataSourceFactory.getRemote().getWeather()
            .run(weatherMapper::mapToDomain)

    }
}