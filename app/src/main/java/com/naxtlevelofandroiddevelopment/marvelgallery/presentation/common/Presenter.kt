package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.common

import io.reactivex.disposables.Disposable

abstract class Presenter {

    var subscriptions: List<Disposable> = emptyList()

    open fun onStart() {}

    open fun onDestroy() {
        subscriptions.forEach { it.dispose() }
    }
}