package com.mohamed.gamal.presentation.factory

import com.mohamed.gamal.domain.models.Weather
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.presentation.models.WeatherPresentation
import com.mohamed.gamal.presentation.models.WeatherResponsePresentation

object WeatherPresentationFactory {
    fun makeWeatherResponsePresentation(): WeatherResponsePresentation {
        val weatherList = mutableListOf<WeatherPresentation>()
        weatherList.add(0, WeatherPresentation(1,"main","desc","icon"))
        return WeatherResponsePresentation("test","test",1,weatherList)
    }
    fun makeWeatherResponse(): WeatherResponse {
        val weatherList = mutableListOf<Weather>()
        weatherList.add(0, Weather(1,"main","desc","icon"))
        return WeatherResponse("test","test",1,weatherList)
    }

}