package com.mohamed.gamal.weather.view.ui.weather.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mohamed.gamal.presentation2.base.Resource
import com.mohamed.gamal.presentation2.viewmodel.WeatherViewModel
import com.mohamed.gamal.weather.R
import com.mohamed.gamal.weather.view.utils.debug
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getWeather()
        observeOnWeather()
    }

    private fun observeOnWeather() {
        viewModel.observeOnWeather(this, { weatherResource ->
            when (weatherResource.state) {
                Resource.Companion.State.LOADING -> {
                    progress.visibility = View.VISIBLE
                    errorText.visibility = View.GONE
                }
                Resource.Companion.State.SUCCESS -> {
                    progress.visibility = View.GONE
                    errorText.visibility = View.GONE
                    cityName.text = weatherResource.value?.name
                    weatherDesc.text = weatherResource.value?.weather?.get(0)?.description
                }
                Resource.Companion.State.ERROR -> {
                    progress.visibility = View.GONE
                    errorText.visibility = View.VISIBLE
                    debug(weatherResource.t.toString())
                }
            }

        })
    }

}