package com.mohamed.gamal.weather

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.mohamed.gamal.data.di.dataModule
import com.mohamed.gamal.domain.di.domainModule
import com.mohamed.gamal.domain.models.WeatherResponse
import com.mohamed.gamal.domain.usecases.weather.GetWeatherUseCase
import com.mohamed.gamal.presentation.di.presentationModule
import com.mohamed.gamal.presentation.mapper.weather.WeatherResponsePresentationMapper
import com.mohamed.gamal.presentation.viewmodel.WeatherViewModel
import com.mohamed.gamal.remote.di.remoteModule
import com.mohamed.gamal.weather.view.ui.weather.activity.WeatherActivity
import io.reactivex.rxjava3.core.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module
import org.mockito.kotlin.mock

@RunWith(JUnit4::class)
class WeatherActivityTest {

//    @get:Rule
//    var intentRule = IntentsTestRule(WeatherActivity::class.java, true, false)

    private val activity = ActivityTestRule(WeatherActivity::class.java)
    private val weatherModule = module {
        remoteModule
        dataModule
        domainModule
        presentationModule
//        val weatherResponsePresentationMapper = mock<WeatherResponsePresentationMapper>()
////        val loginApi = InMemoryLoginApi()
////        val loginRepository = RemoteLoginRepository(loginApi)
        viewModel { WeatherViewModel(getWeatherUseCase = get(),weatherMapper = get()) }
    }

    @Before
    fun setUp() {
        loadKoinModules(weatherModule)
        activity.launchActivity(Intent())
    }
    @After
    fun tearDown() {
        unloadKoinModules(weatherModule)
    }
    @Test
    fun viewTest(){
        Espresso.onView(withId(R.id.cityName))
        Espresso.onView(withId(R.id.weatherDesc))
    }

    private fun stubGetWeatherRepository(observable: Observable<WeatherResponse>){
    }

}