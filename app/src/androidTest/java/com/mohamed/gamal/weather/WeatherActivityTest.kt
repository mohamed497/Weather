package com.mohamed.gamal.weather

import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.weather.view.ui.weather.activity.WeatherActivity
import io.reactivex.rxjava3.core.Observable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.whenever

@RunWith(JUnit4::class)
class WeatherActivityTest {

//    @get:Rule
//    var intentRule = IntentsTestRule(WeatherActivity::class.java, true, false)

//    val activity = ActivityTestRule(WeatherActivity::class.java)

    @Test
    fun viewTest(){
        Espresso.onView(withId(R.id.cityName))
        Espresso.onView(withId(R.id.weatherDesc))
    }

    private fun stubGetWeatherRepository(observable: Observable<WeatherResponse>){
    }
}