package com.mohamed.gamal.remote.mappers.weather

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.remote.mappers.ModelMapper
import com.mohamed.gamal.remote.models.weather.WeatherResponseModel


class WeatherResponseModelMapper(private val weatherMapper: WeatherModelMapper) :
    ModelMapper<WeatherResponseModel, WeatherResponseEntity> {
    override fun mapFromModel(model: WeatherResponseModel?): WeatherResponseEntity {
        return WeatherResponseEntity(
            name = model?.name,
            base = model?.base,
            id = model?.id,
            weather = model?.weather?.map {
                weatherMapper.mapFromModel(it)
            }
        )
    }
}