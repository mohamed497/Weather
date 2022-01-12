package com.mohamed.gamal.data.mappers.weather

import com.mohamed.gamal.data.mappers.EntityMapper
import com.mohamed.gamal.data.models.weather.WeatherEntity
import com.mohamed.gamal.domain.models.Weather

open class WeatherEntityMapper : EntityMapper<WeatherEntity, Weather> {
    override fun mapToDomain(entity: WeatherEntity?): Weather {
        return Weather(
            id = entity?.id,
            main = entity?.main,
            icon = entity?.icon,
            description = entity?.description
        )
    }
}