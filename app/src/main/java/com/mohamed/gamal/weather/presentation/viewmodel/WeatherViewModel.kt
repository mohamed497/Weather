package com.mohamed.gamal.weather.presentation.viewmodel

import androidx.lifecycle.*
import com.mohamed.gamal.weather.domain.models.WeatherResponse
import com.mohamed.gamal.weather.domain.usecases.weather.GetWeatherUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class WeatherViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val weatherLiveData = MutableLiveData<WeatherResponse>()


    fun observeOnAlbums(lifecycle: LifecycleOwner, albums: Observer<WeatherResponse>) {
        weatherLiveData.observe(lifecycle, albums)
    }


    fun getWeather() {
        getWeatherUseCase.getObservable().subscribeBy(
            onNext = {
                weatherLiveData.value = it
            }
        )
    }

//    fun getAlbumsUsingZip() {
//        userRepositoryImpl.getUsers()
//            .flatMap { users ->
//                val album = users.map(::getSingleAlbum)
//                return@flatMap Observable.just(album)
//            }.flatMap { allAlbums ->
//                return@flatMap Observable.create<List<Album>> { emitter ->
//                    allAlbums.zip { albumsUser ->
//                        emitter.onNext(albumsUser.flatten())
//
//                    }.subscribeOn(Schedulers.io())
//                        .subscribe()
//                }
//            }.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeBy(onNext = { albumsList ->
//                insertAlbums(albumsList)
//
//            },
//                onError = { throwable ->
//                    Log.d(Constants.VIEW_MODEL_ERROR, throwable.toString())
//                },
//                onComplete = { Log.d(Constants.VIEW_MODEL_SUCCESS, "Albums_CompleteD") })
//            .let { disposable ->
//                compositeDisposable.add(disposable)
//            }
//    }

//    fun getAlbumsFromCache() {
//        albumsMutableLiveData.value = Resource.loading()
//        userRepositoryImpl.getSavedAlbums().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeBy(onNext = { albumsList ->
//                albumsMutableLiveData.value = Resource.success(albumsList)
//            },
//                onError = { throwable ->
//                    albumsMutableLiveData.value = Resource.error(throwable)
//                    Log.d(Constants.VIEW_MODEL_ERROR, throwable.toString())
//                },
//                onComplete = {
//                    Log.d(
//                        Constants.VIEW_MODEL_SUCCESS,
//                        "Fetch Data From DB Completed"
//                    )
//                }).let { disposable ->
//                compositeDisposable.add(disposable)
//            }
//
//    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
