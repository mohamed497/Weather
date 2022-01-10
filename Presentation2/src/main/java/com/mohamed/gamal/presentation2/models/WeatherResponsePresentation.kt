package com.mohamed.gamal.presentation2.models

data class WeatherResponsePresentation(
    val base: String?,
    val name: String?,
    val id: Int?,
    val weather: List<WeatherPresentation>?
)