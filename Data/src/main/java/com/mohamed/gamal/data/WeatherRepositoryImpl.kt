package com.mohamed.gamal.data

import com.mohamed.gamal.data.mappers.weather.WeatherEntityMapper
import com.mohamed.gamal.data.mappers.weather.WeatherResponseEntityMapper
import com.mohamed.gamal.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable

class WeatherRepositoryImpl(
    private val weatherDataSourceFactory: WeatherDataSourceFactory,
    private val weatherMapper: WeatherResponseEntityMapper
) :
    WeatherRepository {

    override fun getWeather(): Observable<WeatherResponse> {
        return weatherDataSourceFactory.getRemote().getWeather()
//            .map(weatherMapper::mapToDomain)
    }

}