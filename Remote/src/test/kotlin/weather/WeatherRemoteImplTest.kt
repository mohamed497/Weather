package weather

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.remote.WeatherRemoteImpl
import com.mohamed.gamal.remote.mappers.weather.WeatherResponseModelMapper
import com.mohamed.gamal.remote.models.weather.WeatherResponseModel
import com.mohamed.gamal.remote.service.WeatherApiService
import factory.WeatherModelFactory
import io.reactivex.rxjava3.core.Observable
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class WeatherRemoteImplTest {
    private val weatherService = mock<WeatherApiService>()
    private val weatherMapper = mock<WeatherResponseModelMapper>()
    private val weatherRemoteImpl = WeatherRemoteImpl(weatherService, weatherMapper)

    @Test
    fun getWeatherComplete() {
        stubWeatherService(Observable.just(WeatherModelFactory.makeWeatherResponseModel()))
        stubWeatherResponseMapper(any(),WeatherModelFactory.makeWeatherResponseEntity())
        val observer = weatherRemoteImpl.getWeather().test()
        observer.assertComplete()
    }
    @Test
    fun getWeatherResponseReturnData() {
        val response = WeatherModelFactory.makeWeatherResponseModel()
        stubWeatherService(Observable.just(response))
        stubWeatherResponseMapper(any(),WeatherModelFactory.makeWeatherResponseEntity())
        val observer = weatherRemoteImpl.getWeather().test()
        observer.assertValue(WeatherModelFactory.makeWeatherResponseEntity())
    }

    @Test
    fun getWeatherCallServer() {
        stubWeatherService(Observable.just(WeatherModelFactory.makeWeatherResponseModel()))
        stubWeatherResponseMapper(any(),WeatherModelFactory.makeWeatherResponseEntity())
        weatherRemoteImpl.getWeather().test()
        verify(weatherService).getWeather()
    }

    private fun stubWeatherService(observable: Observable<WeatherResponseModel>) {
        whenever(weatherService.getWeather())
            .thenReturn(observable)
    }

    private fun stubWeatherResponseMapper(
        model: WeatherResponseModel,
        entity: WeatherResponseEntity
    ) {
        whenever(weatherMapper.mapFromModel(model))
            .thenReturn(entity)
    }
}