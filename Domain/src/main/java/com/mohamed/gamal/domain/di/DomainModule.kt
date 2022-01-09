package com.mohamed.gamal.domain.di

import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { GetWeatherUseCase(get(), get()) }
}