package com.mohamed.gamal.presentation2.models

data class WeatherResponsePresentation(
    val base: String?,
//    val coord: Coord,
    val name: String?,
    val id: Int?,
//    val sys: Sys,
    val weather: List<WeatherPresentation>?
)