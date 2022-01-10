package com.mohamed.gamal.domain.models

data class WeatherResponse(
    val base: String?,
    val name: String?,
    val id: Int?,
    val weather: List<Weather>?
)