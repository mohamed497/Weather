package factory

import com.mohamed.gamal.data.models.weather.WeatherEntity
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.remote.models.weather.WeatherModel
import com.mohamed.gamal.remote.models.weather.WeatherResponseModel

object WeatherModelFactory {
    fun makeWeatherResponseModel():WeatherResponseModel{
        val weatherList = mutableListOf<WeatherModel>()
        weatherList.add(0,WeatherModel(1,"main","desc","icon"))
        return WeatherResponseModel("test","test",1,weatherList)
    }
    fun makeWeatherResponseEntity():WeatherResponseEntity{
        val weatherList = mutableListOf<WeatherEntity>()
        weatherList.add(0,WeatherEntity(1,"main","desc","icon"))
        return WeatherResponseEntity("test","test",1,weatherList)
    }
}