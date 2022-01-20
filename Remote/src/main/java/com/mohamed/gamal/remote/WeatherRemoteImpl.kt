package com.mohamed.gamal.remote

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.data.repository.weather.WeatherRemote
import com.mohamed.gamal.remote.service.WeatherApiService
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.remote.mappers.weather.WeatherResponseModelMapper
import io.reactivex.rxjava3.core.Observable

class WeatherRemoteImpl(
    private val weatherService: WeatherApiService,
    private val weatherMapper: WeatherResponseModelMapper
) : WeatherRemote {
    override suspend fun getWeather(): WeatherResponseEntity {
        return weatherService.getWeather()
            .run(weatherMapper::mapFromModel)
    }

}