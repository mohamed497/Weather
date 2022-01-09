package com.mohamed.gamal.data.models.weather

import com.mohamed.gamal.data.models.Entity
import com.mohamed.gamal.domain.models.Coord
import com.mohamed.gamal.domain.models.Sys
import com.mohamed.gamal.domain.models.Weather

data class WeatherResponseEntity(
    val base: String?,
//    val coord: Coord,
    val name: String?,
    val id: Int?,
//    val sys: Sys,
    val weather: List<WeatherEntity>?
): Entity