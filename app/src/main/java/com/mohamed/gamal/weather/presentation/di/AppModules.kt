package com.mohamed.gamal.weather.presentation.di

import com.mohamed.gamal.weather.domain.usecases.weather.GetWeatherUseCase
import com.mohamed.gamal.weather.remote.WeatherRemoteRepository
import com.mohamed.gamal.weather.data.WeatherRepositoryImpl
import com.mohamed.gamal.weather.data.repository.weather.WeatherRemote
import com.mohamed.gamal.weather.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.weather.data.store.weather.WeatherRemoteDataStore
import com.mohamed.gamal.weather.domain.repository.WeatherRepository
import com.mohamed.gamal.weather.presentation.viewmodel.WeatherViewModel
import com.mohamed.gamal.weather.remote.WeatherRemoteImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(getWeatherUseCase = get()) }
}

val weatherRepositoryImplModule = module {

    single<WeatherRepository> { WeatherRepositoryImpl(weatherDataSourceFactory = get()) }

}
val weatherDataSourceFactory = module {
    single { WeatherDataSourceFactory(weatherRemoteDataStore = get()) }
}
val weatherRemoteDataStore = module {
    single { WeatherRemoteDataStore(weatherRemote = get()) }
}
val repositoryModule = module {
    single { WeatherRemoteRepository(weatherService = get()) }
}
val weatherRemoteImpl = module {
    single<WeatherRemote> { WeatherRemoteImpl(weatherService = get()) }
}


val useCaseModule = module {
    single { GetWeatherUseCase(weatherRepository = get()) }
}

