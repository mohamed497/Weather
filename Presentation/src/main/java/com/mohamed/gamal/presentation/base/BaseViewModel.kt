package com.mohamed.gamal.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()
    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}