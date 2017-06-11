package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.naxtlevelofandroiddevelopment.marvelgallery.BuildConfig

abstract class PresenterBaseActivity : AppCompatActivity(), BaseView {

    abstract val presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showError(error: Throwable) {
        toast("Error: ${error.message}")
        if(BuildConfig.DEBUG) {
            error.printStackTrace()
            error.cause?.printStackTrace()
        }
    }
}
