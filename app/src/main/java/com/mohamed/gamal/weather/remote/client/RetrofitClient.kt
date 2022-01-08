package com.mohamed.gamal.weather.remote.client

import com.mohamed.gamal.weather.remote.client.NetworkConstants.BASE_URL
import com.mohamed.gamal.weather.remote.service.WeatherApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun createRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun <T> createServiceClass(retrofit: Retrofit, classObj: Class<T>): T {
        return retrofit.create(classObj)
    }

}