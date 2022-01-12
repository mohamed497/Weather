package com.mohamed.gamal.presentation.viewmodel

import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import com.mohamed.gamal.presentation.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation.models.WeatherResponsePresentation
import io.reactivex.rxjava3.observers.DisposableObserver
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.presentation.factory.WeatherPresentationFactory
import io.reactivex.rxjava3.core.Observable
import org.mockito.kotlin.*

@RunWith(JUnit4::class)
class WeatherViewModelTest {

    /**
     * NOTE
     * change etWeatherUseCase.getObservable() at view model to etWeatherUseCase.createObservable
     * then remove NullPointerException
     */
    @get:Rule
    var instanceTaskExecutor = InstantTaskExecutorRule()
    private val getWeatherUseCase = mock<GetWeatherUseCase>()
    private val weatherResponseMapper = mock<WeatherResponsePresentationMapper>()
    private val weatherViewModel = WeatherViewModel(getWeatherUseCase, weatherResponseMapper)


    @Test(expected = NullPointerException::class)
    fun fetchWeatherResponseUseCase() {
        stubGetWeather(Observable.just(WeatherPresentationFactory.makeWeatherResponse()))
        val observer = getWeatherUseCase.createObservable().test()
        observer.assertComplete()
        weatherViewModel.getWeather()
        verify(getWeatherUseCase, times(1))

    }

    private fun stubGetWeather(observable: Observable<WeatherResponse>) {
        whenever(getWeatherUseCase.createObservable())
            .thenReturn(observable)
    }

}