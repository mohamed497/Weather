package repository

import com.mohamed.gamal.data.WeatherRepositoryImpl
import com.mohamed.gamal.data.mappers.weather.WeatherResponseEntityMapper
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.data.repository.weather.WeatherDataStore
import com.mohamed.gamal.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.data.store.weather.WeatherRemoteDataStore
import com.mohamed.gamal.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import store.factory.WeatherEntityFactory

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class WeatherRepositoryImplTest {
    private val mapper = mock<WeatherResponseEntityMapper>()
    private val store = mock<WeatherDataStore>()
    private val factory = mock<WeatherDataSourceFactory>()
    private val repository = WeatherRepositoryImpl(factory, mapper)

    @Before
    fun setup() {
        stubFactoryGetDataStore()
    }

    @Test
    fun getWeatherComplete() {
        runTest {
            stubGetWeather(WeatherEntityFactory.makeWeatherResponseEntity())
            stubMapper(
                WeatherEntityFactory.makeWeatherResponseEntity(),
                WeatherEntityFactory.makeWeatherResponse()
            )
            val response = repository.getWeather()
            Assert.assertEquals(response, WeatherEntityFactory.makeWeatherResponse())
        }
    }

    private fun stubMapper(entity: WeatherResponseEntity, model: WeatherResponse) {
        whenever(mapper.mapToDomain(entity))
            .thenReturn(model)
    }

    private fun stubFactoryGetDataStore() {
        runTest {
            whenever(factory.getRemote())
                .thenReturn(store)
        }

    }

    private fun stubGetWeather(weatherResponseEntity: WeatherResponseEntity) {
        runTest {

            whenever(store.getWeather())
                .thenReturn(weatherResponseEntity)
        }
    }
}