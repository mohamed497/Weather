package store.factory

import com.mohamed.gamal.data.models.weather.WeatherEntity
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity

object WeatherEntityFactory {
    fun makeWeatherResponseEntity():WeatherResponseEntity{
        val weatherList = mutableListOf<WeatherEntity>()
        weatherList.add(0,WeatherEntity(1,"main","desc","icon"))
        return WeatherResponseEntity("test","test",1,weatherList)
    }
    fun makeWeatherEntity():WeatherEntity{
        return WeatherEntity(1,"main","desc","icon")
    }
}