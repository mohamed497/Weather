package com.mohamed.gamal.presentation2.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import com.mohamed.gamal.presentation2.base.Resource
import com.mohamed.gamal.presentation2.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation2.models.WeatherResponsePresentation
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherMapper: WeatherResponsePresentationMapper
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val weatherLiveData = MutableLiveData<Resource<WeatherResponsePresentation>>()


    fun observeOnWeather(
        lifecycle: LifecycleOwner,
        weather: Observer<Resource<WeatherResponsePresentation>>
    ) {
        weatherLiveData.observe(lifecycle, weather)
    }


    fun getWeather() {
        weatherLiveData.value = Resource.loading()
        getWeatherUseCase.getObservable().subscribeBy(
            onNext = { weatherResponse ->
                weatherLiveData.value =
                    Resource.success(weatherMapper.mapToPresentation(weatherResponse))
            },
            onError = { throwable ->
                weatherLiveData.value = Resource.error(throwable)
            },
            onComplete = {
                Log.d(
                    WeatherViewModel::class.java.simpleName,
                    "Fetch Data Completed"
                )
            }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
