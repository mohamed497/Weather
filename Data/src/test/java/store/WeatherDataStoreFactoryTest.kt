package store

import com.mohamed.gamal.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.data.store.weather.WeatherRemoteDataStore
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock

class WeatherDataStoreFactoryTest {
    private val remoteStore = mock<WeatherRemoteDataStore>()
    private val factory = WeatherDataSourceFactory(remoteStore)

    @Test
    fun getDataStoreReturnRemote(){
        Assert.assertEquals(remoteStore,factory.getRemote())
    }
}