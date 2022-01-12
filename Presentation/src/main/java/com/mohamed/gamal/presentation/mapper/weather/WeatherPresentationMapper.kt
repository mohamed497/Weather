package com.mohamed.gamal.presentation.mapper.weather

import com.mohamed.gamal.domain.models.Weather
import com.mohamed.gamal.presentation.mapper.PresentationMapper
import com.mohamed.gamal.presentation.models.WeatherPresentation

open class WeatherPresentationMapper :
    PresentationMapper<Weather, WeatherPresentation> {
    override fun mapToPresentation(domain: Weather?): WeatherPresentation {
        return WeatherPresentation(
            id = domain?.id,
            description = domain?.description,
            icon = domain?.icon,
            main = domain?.main
        )
    }
}