package mapper

import com.mohamed.gamal.data.mappers.weather.WeatherEntityMapper
import com.mohamed.gamal.data.mappers.weather.WeatherResponseEntityMapper
import com.mohamed.gamal.data.models.weather.WeatherEntity
import com.mohamed.gamal.data.models.weather.WeatherResponseEntity
import com.mohamed.gamal.domain.models.Weather
import com.mohamed.gamal.domain.models.WeatherResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert
import store.factory.WeatherEntityFactory

@RunWith(JUnit4::class)
class WeatherMapperTest {

    private val weatherMapper = WeatherEntityMapper()
    private val weatherResponseMapper = WeatherResponseEntityMapper(weatherMapper)

    @Test
    fun mapFromWeatherEntityToDomain(){
        val entity = WeatherEntityFactory.makeWeatherEntity()
        val model = weatherMapper.mapToDomain(entity)
        assertEqualDataWeatherEntity(entity,model)
    }

    private fun assertEqualDataWeatherEntity(entity: WeatherEntity, model: Weather) {
        Assert.assertEquals(entity.id,model.id)
        Assert.assertEquals(entity.description,model.description)
        Assert.assertEquals(entity.icon,model.icon)
        Assert.assertEquals(entity.main,model.main)
    }
    @Test
    fun mapFromWeatherResponseEntityToDomain(){
        val entity = WeatherEntityFactory.makeWeatherResponseEntity()
        val model = weatherResponseMapper.mapToDomain(entity)
        assertEqualDataWeatherResponseEntity(entity,model)
    }

    private fun assertEqualDataWeatherResponseEntity(entity: WeatherResponseEntity, model: WeatherResponse) {
        Assert.assertEquals(entity.id,model.id)
        Assert.assertEquals(entity.base,model.base)
        Assert.assertEquals(entity.name,model.name)
    }


}