package com.mohamed.gamal.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import com.mohamed.gamal.presentation.base.BaseViewModel
import com.mohamed.gamal.presentation.base.Resource
import com.mohamed.gamal.presentation.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation.models.WeatherResponsePresentation
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

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
        weatherLiveData.postValue(Resource.loading())
        getWeatherUseCase.getObservable().subscribeBy(
            onNext = { weatherResponse ->
                weatherLiveData.postValue(
                    Resource.success(weatherMapper.mapToPresentation(weatherResponse))
                )
            },
            onError = { throwable ->
                weatherLiveData.postValue(Resource.error(throwable))
            },
            onComplete = {
                Log.d(
                    WeatherViewModel::class.java.simpleName,
                    "Fetch Data Completed"
                )
            }
        )
    }

}
