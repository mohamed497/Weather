package com.mohamed.gamal.weather.data

import com.mohamed.gamal.weather.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.weather.domain.models.WeatherResponse
import com.mohamed.gamal.weather.remote.WeatherRemoteRepository
import com.mohamed.gamal.weather.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable

class WeatherRepositoryImpl(private val weatherDataSourceFactory: WeatherDataSourceFactory) :
    WeatherRepository {

    override fun getWeather(): Observable<WeatherResponse> {
        return weatherDataSourceFactory.getRemote().getWeather()
    }

}