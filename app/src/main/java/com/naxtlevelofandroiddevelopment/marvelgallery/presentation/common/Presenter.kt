package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.common

import io.reactivex.disposables.Disposable

abstract class Presenter {

    var subscriptions: List<Disposable> = emptyList()

    open fun onCreate() {}

    open fun onDestroy() {
        subscriptions.forEach { it.dispose() }
    }
}