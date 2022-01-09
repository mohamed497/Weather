package com.mohamed.gamal.data.models.weather

import com.mohamed.gamal.data.models.Entity

data class WeatherEntity(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?
) : Entity