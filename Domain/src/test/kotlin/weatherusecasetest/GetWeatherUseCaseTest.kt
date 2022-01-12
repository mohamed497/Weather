package weatherusecasetest

import com.mohamed.gamal.domain.executor.PostExecutionThread
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.repository.WeatherRepository
import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import factory.WeatherFactory
import io.reactivex.rxjava3.core.Observable
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetWeatherUseCaseTest {

    private val weatherRepository = mock<WeatherRepository>()
    private val schedulerThread = mock<PostExecutionThread>()
    private val getWeatherUseCase = GetWeatherUseCase(weatherRepository,schedulerThread)

    @Test
    fun getWeatherComplete(){
        stubGetWeather(Observable.just(WeatherFactory.makeWeatherResponse()))
        val observer = getWeatherUseCase.createObservable().test()
        observer.assertComplete()
    }

    @Test
    fun getWeatherReturnData(){
        val weather = WeatherFactory.makeWeatherResponse()
        stubGetWeather(Observable.just(weather))
        val observer = getWeatherUseCase.createObservable().test()
        observer.assertValue(weather)
    }
    private fun stubGetWeather(observable: Observable<WeatherResponse>){
        whenever(weatherRepository.getWeather())
            .thenReturn(observable)
    }
}