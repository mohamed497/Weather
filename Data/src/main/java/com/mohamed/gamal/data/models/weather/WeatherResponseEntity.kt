package com.mohamed.gamal.data.models.weather

data class WeatherResponseEntity(
    val base: String?,
    val name: String?,
    val id: Int?,
    val weather: List<WeatherEntity>?
)