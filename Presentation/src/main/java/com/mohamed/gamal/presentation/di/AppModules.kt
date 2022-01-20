package com.mohamed.gamal.presentation.di


import com.mohamed.gamal.presentation.mapper.weather.WeatherPresentationMapper
import com.mohamed.gamal.presentation.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.dsl.module

val presentationModule = module {
    viewModel { WeatherViewModel(getWeatherUseCase = get(), weatherMapper = get()) }

    factory { WeatherPresentationMapper() }
    factory { WeatherResponsePresentationMapper(get()) }

}

