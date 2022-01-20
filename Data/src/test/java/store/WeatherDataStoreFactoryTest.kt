package store

import com.mohamed.gamal.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.data.store.weather.WeatherRemoteDataStore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class WeatherDataStoreFactoryTest {
    private val remoteStore = mock<WeatherRemoteDataStore>()
    private val factory = WeatherDataSourceFactory(remoteStore)


    @Test
    fun getDataStoreReturnRemote() {
        runTest {
            Assert.assertEquals(remoteStore, factory.getRemote())
        }
    }
}