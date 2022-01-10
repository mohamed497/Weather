package com.mohamed.gamal.data.models.weather

import com.mohamed.gamal.data.models.Entity

data class WeatherResponseEntity(
    val base: String?,
    val name: String?,
    val id: Int?,
    val weather: List<WeatherEntity>?
): Entity