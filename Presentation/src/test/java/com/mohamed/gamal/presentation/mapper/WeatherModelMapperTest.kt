package com.mohamed.gamal.presentation.mapper

import com.mohamed.gamal.domain.models.Weather
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.presentation.factory.WeatherPresentationFactory
import com.mohamed.gamal.presentation.mapper.weather.WeatherPresentationMapper
import com.mohamed.gamal.presentation.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation.models.WeatherPresentation
import com.mohamed.gamal.presentation.models.WeatherResponsePresentation
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(JUnit4::class)
class WeatherModelMapperTest {

    private val weatherMapper = mock<WeatherPresentationMapper>()
    private val weatherResponseMapper = WeatherResponsePresentationMapper(weatherMapper)

    @Test
    fun mapFromWeatherResponseEntityToDomain() {
        val weatherResponse = WeatherPresentationFactory.makeWeatherResponse()
        val weatherResponsePresentation = weatherResponseMapper.mapToPresentation(weatherResponse)
        assertEqualDataWeatherResponseEntity(weatherResponsePresentation, weatherResponse)
    }

    private fun assertEqualDataWeatherResponseEntity(
        weatherResponsePresentation: WeatherResponsePresentation,
        weatherResponse: WeatherResponse
    ) {
        Assert.assertEquals(weatherResponsePresentation.id,weatherResponse.id)
        Assert.assertEquals(weatherResponsePresentation.base,weatherResponse.base)
        Assert.assertEquals(weatherResponsePresentation.name,weatherResponse.name)
        stubbingWeather(weatherResponsePresentation.weather?.get(0),weatherResponse.weather?.get(0))
    }

    private fun stubbingWeather(weatherPresentation: WeatherPresentation?, weather: Weather?) {
        whenever(weatherMapper.mapToPresentation(weather))
            .thenReturn(weatherPresentation)
    }
}