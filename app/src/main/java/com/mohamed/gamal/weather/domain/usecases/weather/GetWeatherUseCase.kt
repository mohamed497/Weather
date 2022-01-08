package com.mohamed.gamal.weather.domain.usecases.weather

import com.mohamed.gamal.weather.domain.models.WeatherResponse
import com.mohamed.gamal.weather.domain.usecases.BaseObservableUseCase
import com.mohamed.gamal.weather.data.WeatherRepositoryImpl
import com.mohamed.gamal.weather.domain.repository.WeatherRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository
) :
    BaseObservableUseCase<WeatherResponse, Any>() {
    override fun createObservable(params: Any?): Observable<WeatherResponse> {
        return weatherRepository.getWeather().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}