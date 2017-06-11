package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.main

import com.naxtlevelofandroiddevelopment.marvelgallery.network.MarvelRepository
import com.naxtlevelofandroiddevelopment.marvelgallery.network.applySchedulers
import com.naxtlevelofandroiddevelopment.marvelgallery.network.smartSubscribe
import com.naxtlevelofandroiddevelopment.marvelgallery.presentation.common.Presenter

class MainPresenter(val view: MainView) : Presenter() {

    val repository by MarvelRepository.lazyGet()

    override fun onCreate() {
        super.onCreate()
        loadCharacters()
    }

    fun searchChanged(newText: String) {
        loadCharacters(newText)
    }

    private fun loadCharacters(search: String = "") {
        val qualifiedSearchQuery = if(search.isBlank()) null else search
        subscriptions += repository
                .getCharacters(qualifiedSearchQuery)
                .applySchedulers()
                .smartSubscribe(
                        onSuccess = view::show,
                        onError = view::showError,
                        onFinish = { view.refresh = false }
                )
    }
}