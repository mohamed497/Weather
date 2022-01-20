package store

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.data.repository.weather.WeatherRemote
import com.mohamed.gamal.data.store.weather.WeatherRemoteDataStore
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import store.factory.WeatherEntityFactory

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class WeatherRemoteDataStoreTest {
    private val remote = mock<WeatherRemote>()
    private val store = WeatherRemoteDataStore(remote)

    @Test
    fun getWeatherReturnData() {
        runTest {
            val response = WeatherEntityFactory.makeWeatherResponseEntity()
            stubbingRemoteGetProjects(response)
            val testResponse = store.getWeather()
            Assert.assertEquals(response, testResponse)
        }

    }

    private fun stubbingRemoteGetProjects(weatherResponseEntity: WeatherResponseEntity) {
        runTest {
            whenever(remote.getWeather())
                .thenReturn(weatherResponseEntity)
        }

    }

}