package com.mohamed.gamal.presentation2.mapper.weather

import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.presentation2.mapper.PresentationMapper
import com.mohamed.gamal.presentation2.models.WeatherResponsePresentation

class WeatherResponsePresentationMapper(private val weatherMapper: WeatherPresentationMapper) :
    PresentationMapper<WeatherResponse, WeatherResponsePresentation> {
    override fun mapToPresentation(domain: WeatherResponse?): WeatherResponsePresentation {
        return WeatherResponsePresentation(
            id = domain?.id,
            name = domain?.name,
            base = domain?.base,
            weather = domain?.weather?.map { weather ->
                weatherMapper.mapToPresentation(weather)
            }
        )
    }
}