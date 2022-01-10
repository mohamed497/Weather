package com.mohamed.gamal.remote.models.weather

data class WeatherResponseModel(
    val base: String?,
    val name: String?,
    val id: Int?,
    val weather: List<WeatherModel>?
)