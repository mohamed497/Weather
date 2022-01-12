package com.mohamed.gamal.remote.mappers.weather

import com.mohamed.gamal.data.models.weather.WeatherEntity
import com.mohamed.gamal.remote.mappers.ModelMapper
import com.mohamed.gamal.remote.models.weather.WeatherModel

open class WeatherModelMapper :
    ModelMapper<WeatherModel, WeatherEntity> {
    override fun mapFromModel(model: WeatherModel?): WeatherEntity {
        return WeatherEntity(
            id = model?.id,
            description = model?.description,
            icon = model?.icon,
            main = model?.main
        )
    }
}