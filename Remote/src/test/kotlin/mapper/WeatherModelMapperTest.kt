package mapper

import com.mohamed.gamal.data.models.weather.WeatherEntity
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.remote.mappers.weather.WeatherModelMapper
import com.mohamed.gamal.remote.mappers.weather.WeatherResponseModelMapper
import com.mohamed.gamal.remote.models.weather.WeatherModel
import com.mohamed.gamal.remote.models.weather.WeatherResponseModel
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import factory.WeatherModelFactory
import io.reactivex.rxjava3.core.Observable
import org.junit.Assert
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(JUnit4::class)
class WeatherModelMapperTest {

    private val weatherMapper = mock<WeatherModelMapper>()
    private val weatherResponseMapper = WeatherResponseModelMapper(weatherMapper)

    @Test
    fun mapFromWeatherResponseEntityToDomain(){
        val model = WeatherModelFactory.makeWeatherResponseModel()
        val entity = weatherResponseMapper.mapFromModel(model)
        assertEqualDataWeatherResponseEntity(model,entity)
    }

    private fun assertEqualDataWeatherResponseEntity(model: WeatherResponseModel, entity: WeatherResponseEntity) {
        Assert.assertEquals(entity.id,model.id)
        Assert.assertEquals(entity.base,model.base)
        Assert.assertEquals(entity.name,model.name)
        stubbingWeather(model.weather?.get(0),entity.weather?.get(0))
    }
    private fun stubbingWeather(weather: WeatherModel?,entity: WeatherEntity?){
        whenever(weatherMapper.mapFromModel(weather))
            .thenReturn(entity)
    }
}