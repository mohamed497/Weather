package com.mohamed.gamal.weather.remote.service

import com.mohamed.gamal.weather.domain.models.WeatherResponse
import com.mohamed.gamal.weather.remote.client.NetworkConstants.API_KEY
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

const val URL = "2.5/weather?q=London&appid="

interface WeatherApiService {

    @GET("${URL}${API_KEY}")
    fun getWeather(): Observable<WeatherResponse>

}
