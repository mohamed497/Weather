package com.mohamed.gamal.remote.models.weather

import com.mohamed.gamal.remote.models.RemoteModel

data class WeatherResponseModel(
    val base: String?,
    val name: String?,
    val id: Int?,
    val weather: List<WeatherModel>?
):RemoteModel