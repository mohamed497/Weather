package store.factory

import com.mohamed.gamal.data.models.weather.WeatherEntity
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.domain.models.Weather
import com.mohamed.gamal.domain.models.WeatherResponse

object WeatherEntityFactory {
    fun makeWeatherResponseEntity():WeatherResponseEntity{
        val weatherList = mutableListOf<WeatherEntity>()
        weatherList.add(0,WeatherEntity(1,"main","desc","icon"))
        return WeatherResponseEntity("test","test",1,weatherList)
    }
    fun makeWeatherResponse(): WeatherResponse {
        val weatherList = mutableListOf<Weather>()
        weatherList.add(0,Weather(1,"main","desc","icon"))
        return WeatherResponse("test","test",1,weatherList)
    }
    fun makeWeatherEntity():WeatherEntity{
        return WeatherEntity(1,"main","desc","icon")
    }
}