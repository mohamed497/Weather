package repository

import com.mohamed.gamal.data.WeatherRepositoryImpl
import com.mohamed.gamal.data.mappers.weather.WeatherResponseEntityMapper
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.data.repository.weather.WeatherDataStore
import com.mohamed.gamal.data.store.weather.WeatherDataSourceFactory
import com.mohamed.gamal.data.store.weather.WeatherRemoteDataStore
import com.mohamed.gamal.domain.models.WeatherResponse
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import store.factory.WeatherEntityFactory

@RunWith(JUnit4::class)
class WeatherRepositoryImplTest {
    private val mapper = mock<WeatherResponseEntityMapper>()
    private val store = mock<WeatherDataStore>()
    private val factory = mock<WeatherDataSourceFactory>()
    private val repository = WeatherRepositoryImpl(factory,mapper)

    @Before
    fun setup(){
        stubFactoryGetDataStore()
    }

    @Test
    fun getWeatherComplete(){
        stubGetWeather(Observable.just(WeatherEntityFactory.makeWeatherResponseEntity()))
        stubMapper(WeatherEntityFactory.makeWeatherResponseEntity(), WeatherEntityFactory.makeWeatherResponse())
        val observer = repository.getWeather().test()
        observer.assertComplete()
    }
    private fun stubMapper(entity: WeatherResponseEntity, model: WeatherResponse){
        whenever(mapper.mapToDomain(entity))
            .thenReturn(model)
    }
    private fun stubFactoryGetDataStore(){
        whenever(factory.getRemote())
            .thenReturn(store)
    }
    private fun stubGetWeather(observable: Observable<WeatherResponseEntity>){
        whenever(store.getWeather())
            .thenReturn(observable)
    }

}