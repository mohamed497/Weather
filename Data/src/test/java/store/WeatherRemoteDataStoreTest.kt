package store

import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.data.repository.weather.WeatherRemote
import com.mohamed.gamal.data.store.weather.WeatherRemoteDataStore
import io.reactivex.rxjava3.core.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import store.factory.WeatherEntityFactory

@RunWith(JUnit4::class)
class WeatherRemoteDataStoreTest {
    private val remote = mock<WeatherRemote>()
    private val store = WeatherRemoteDataStore(remote)


    @Test
    fun getWeatherCompletes(){
        stubbingRemoteGetProjects(Observable.just(WeatherEntityFactory.makeWeatherResponseEntity()))
        val testObserver = store.getWeather().test()
        testObserver.assertComplete()
    }
    @Test
    fun getWeatherReturnData(){
        val response = WeatherEntityFactory.makeWeatherResponseEntity()
        stubbingRemoteGetProjects(Observable.just(response))
        val testObserver = store.getWeather().test()
        testObserver.assertValue(response)
    }

    private fun stubbingRemoteGetProjects(observable:Observable<WeatherResponseEntity>){
        whenever(remote.getWeather())
            .thenReturn(observable)
    }

}