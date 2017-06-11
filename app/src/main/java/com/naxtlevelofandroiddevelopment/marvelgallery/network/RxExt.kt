package com.naxtlevelofandroiddevelopment.marvelgallery.network

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object Rx {
    var unitTestMode = false
}

fun <T> Observable<T>.applySchedulers(): Observable<T> = if (Rx.unitTestMode) this else
    subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.smartSubscribe(
        onStart: (() -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null,
        onFinish: (() -> Unit)? = null,
        onSuccess: (T) -> Unit = {}
): Disposable =
        addStartFinishActions(onStart, onFinish)
                .subscribe(onSuccess, { onError?.invoke(it) })

fun <T> Observable<T>.addStartFinishActions(onStart: (() -> Unit)? = null, onFinish: (() -> Unit)? = null): Observable<T> {
    onStart?.invoke()
    return doOnTerminate({ onFinish?.invoke() })
}