package com.mohamed.gamal.weather.view.ui.weather.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mohamed.gamal.weather.R
import com.mohamed.gamal.weather.presentation.viewmodel.WeatherViewModel
import com.mohamed.gamal.weather.view.utils.debug
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getWeather()
        viewModel.observeOnAlbums(this, { weatherResponse ->
            cityName.text = weatherResponse.name
            weatherDesc.text = weatherResponse.weather[0].description
            debug(weatherResponse.weather[0].description)
        })
    }

}