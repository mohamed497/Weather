package com.mohamed.gamal.data.mappers.weather

import com.mohamed.gamal.data.mappers.EntityMapper
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.domain.models.WeatherResponse


open class WeatherResponseEntityMapper(private val weatherMapper: WeatherEntityMapper) :
    EntityMapper<WeatherResponseEntity, WeatherResponse> {
    override fun mapToDomain(entity: WeatherResponseEntity?): WeatherResponse {
        return WeatherResponse(
            id = entity?.id,
            base = entity?.base,
            name = entity?.name,
            weather = entity?.weather?.map { weather ->
                weatherMapper.mapToDomain(weather)
            }
        )
    }
}