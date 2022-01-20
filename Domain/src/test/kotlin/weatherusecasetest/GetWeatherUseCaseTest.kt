package weatherusecasetest

import com.mohamed.gamal.domain.executor.PostExecutionThread
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.repository.WeatherRepository
import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import factory.WeatherFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetWeatherUseCaseTest {

    private val weatherRepository = mock<WeatherRepository>()
    private val getWeatherUseCase = GetWeatherUseCase(weatherRepository)

    @Test
    fun getWeatherReturnData() {

        runTest {
            val weather = WeatherFactory.makeWeatherResponse()
            stubGetWeather(weather)
            val weatherResponse = getWeatherUseCase.createWeatherResponse()
            Assert.assertEquals(weather, weatherResponse)

        }
    }

    private fun stubGetWeather(weatherResponse: WeatherResponse) {
        runTest {

            whenever(weatherRepository.getWeather())
                .thenReturn(weatherResponse)
        }

    }
}