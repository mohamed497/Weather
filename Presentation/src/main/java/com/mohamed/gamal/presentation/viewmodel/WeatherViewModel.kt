package com.mohamed.gamal.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import com.mohamed.gamal.presentation.base.BaseViewModel
import com.mohamed.gamal.presentation.base.Resource
import com.mohamed.gamal.presentation.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation.models.WeatherResponsePresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherMapper: WeatherResponsePresentationMapper
) : BaseViewModel() {
    private val weatherLiveData = MutableLiveData<Resource<WeatherResponsePresentation>>()

    fun observeOnWeather(
        lifecycle: LifecycleOwner,
        weather: Observer<Resource<WeatherResponsePresentation>>
    ) {
        weatherLiveData.observe(lifecycle, weather)
    }

    fun getWeather() {
        super.uiScope.launch {
            try {
                weatherLiveData.postValue(Resource.loading())
                withContext(Dispatchers.IO) {
                    weatherLiveData.postValue(
                        Resource.success(
                            getWeatherUseCase.createWeatherResponse()
                                .run(weatherMapper::mapToPresentation)
                        )
                    )
                }
            } catch (t: Throwable) {
                weatherLiveData.postValue(Resource.error(t))
            }

        }
    }
}
