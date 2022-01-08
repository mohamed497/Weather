package com.mohamed.gamal.weather.domain.models

data class WeatherResponse(
    val base: String,
    val coord: Coord,
    val name: String,
    val id: Int,
    val sys: Sys,
    val weather: List<Weather>
)