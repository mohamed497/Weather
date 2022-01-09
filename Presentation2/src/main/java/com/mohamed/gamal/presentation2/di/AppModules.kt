package com.mohamed.gamal.presentation2.di


import com.mohamed.gamal.domain.executor.PostExecutionThread
import com.mohamed.gamal.presentation2.PostExecutionThreadImp
import com.mohamed.gamal.presentation2.mapper.weather.WeatherPresentationMapper
import com.mohamed.gamal.presentation2.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation2.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.dsl.module

val presentationModule = module {
    viewModel { WeatherViewModel(getWeatherUseCase = get()) }
    single<PostExecutionThread> { PostExecutionThreadImp() }

    factory { WeatherPresentationMapper() }
    factory { WeatherResponsePresentationMapper(get()) }

}

