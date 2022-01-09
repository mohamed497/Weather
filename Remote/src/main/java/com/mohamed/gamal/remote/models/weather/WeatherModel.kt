package com.mohamed.gamal.remote.models.weather

import com.mohamed.gamal.remote.models.RemoteModel

data class WeatherModel(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?
) : RemoteModel