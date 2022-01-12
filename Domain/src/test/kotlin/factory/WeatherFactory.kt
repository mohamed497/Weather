package factory

import com.mohamed.gamal.domain.models.Weather
import com.mohamed.gamal.domain.models.WeatherResponse


object WeatherFactory {
    fun makeWeatherResponse(): WeatherResponse {
        val weatherList = mutableListOf<Weather>()
        weatherList.add(0, Weather(1, "main", "desc", "icon"))
        return WeatherResponse("test", "test", 1, weatherList)
    }
}