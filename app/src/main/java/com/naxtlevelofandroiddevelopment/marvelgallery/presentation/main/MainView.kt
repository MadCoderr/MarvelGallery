package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.main

import com.naxtlevelofandroiddevelopment.marvelgallery.model.MarvelCharacter
import com.naxtlevelofandroiddevelopment.marvelgallery.presentation.common.BaseView

interface MainView: BaseView {
    var refresh: Boolean
    fun show(items: List<MarvelCharacter>)
}