package com.mohamed.gamal.remote.service

import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.remote.client.NetworkConstants.API_KEY
import com.mohamed.gamal.remote.models.weather.WeatherResponseModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

const val URL = "2.5/weather?q=London&appid="

interface WeatherApiService {

    @GET("${URL}${API_KEY}")
    fun getWeather(): Observable<WeatherResponseModel>

}
