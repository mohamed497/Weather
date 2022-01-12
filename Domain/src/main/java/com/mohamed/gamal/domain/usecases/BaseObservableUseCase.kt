package com.mohamed.gamal.domain.usecases

import com.mohamed.gamal.domain.executor.PostExecutionThread
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseObservableUseCase<T, P>(private val schedulerThread: PostExecutionThread) {

    fun getObservable(params: P? = null): Observable<T> =
        createObservable(params = params)
            .subscribeOn(Schedulers.io())
            .observeOn(schedulerThread.scheduler)

    abstract fun createObservable(params: P? = null): Observable<T>
}