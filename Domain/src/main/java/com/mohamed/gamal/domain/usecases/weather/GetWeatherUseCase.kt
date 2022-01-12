package com.mohamed.gamal.domain.usecases.weather

import com.mohamed.gamal.domain.executor.PostExecutionThread
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.usecases.BaseObservableUseCase
import com.mohamed.gamal.domain.repository.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


open class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    schedulerThread: PostExecutionThread
) :
    BaseObservableUseCase<WeatherResponse, Any>(schedulerThread) {
    override fun createObservable(params: Any?): Observable<WeatherResponse> {
        return weatherRepository.getWeather()
    }
}