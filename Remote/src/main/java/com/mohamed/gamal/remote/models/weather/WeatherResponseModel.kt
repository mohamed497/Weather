package com.mohamed.gamal.remote.models.weather

import com.mohamed.gamal.domain.models.Coord
import com.mohamed.gamal.domain.models.Sys
import com.mohamed.gamal.domain.models.Weather
import com.mohamed.gamal.remote.models.RemoteModel

data class WeatherResponseModel(
    val base: String?,
//    val coord: Coord,
    val name: String?,
    val id: Int?,
//    val sys: Sys,
    val weather: List<WeatherModel>?
) : RemoteModel