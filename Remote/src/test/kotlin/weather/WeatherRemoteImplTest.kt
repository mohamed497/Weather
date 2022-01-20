package weather

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.remote.WeatherRemoteImpl
import com.mohamed.gamal.remote.mappers.weather.WeatherResponseModelMapper
import com.mohamed.gamal.remote.models.weather.WeatherResponseModel
import com.mohamed.gamal.remote.service.WeatherApiService
import factory.WeatherModelFactory
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class WeatherRemoteImplTest {
    private val weatherService = mock<WeatherApiService>()
    private val weatherMapper = mock<WeatherResponseModelMapper>()
    private val weatherRemoteImpl = WeatherRemoteImpl(weatherService, weatherMapper)

    @Test
    fun getWeatherResponseReturnData() {
        runTest {
            val response = WeatherModelFactory.makeWeatherResponseEntity()
            stubWeatherService(WeatherModelFactory.makeWeatherResponseModel())
            stubWeatherResponseMapper(any(), WeatherModelFactory.makeWeatherResponseEntity())
            val weatherResponse = weatherRemoteImpl.getWeather()
            Assert.assertEquals(response, weatherResponse)
        }

    }

    @Test
    fun getWeatherCallServer() {
        runTest {
            stubWeatherService(WeatherModelFactory.makeWeatherResponseModel())
            stubWeatherResponseMapper(any(), WeatherModelFactory.makeWeatherResponseEntity())
            weatherRemoteImpl.getWeather()
            verify(weatherService).getWeather()
        }

    }

    private fun stubWeatherService(weatherResponseModel: WeatherResponseModel) {
        runTest {
            whenever(weatherService.getWeather())
                .thenReturn(weatherResponseModel)
        }

    }

    private fun stubWeatherResponseMapper(
        model: WeatherResponseModel,
        entity: WeatherResponseEntity
    ) {
        whenever(weatherMapper.mapFromModel(model))
            .thenReturn(entity)
    }
}