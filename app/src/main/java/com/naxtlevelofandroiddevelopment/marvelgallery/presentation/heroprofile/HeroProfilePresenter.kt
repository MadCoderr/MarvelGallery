package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.heroprofile;

import com.naxtlevelofandroiddevelopment.marvelgallery.R
import com.naxtlevelofandroiddevelopment.marvelgallery.model.MarvelCharacter
import com.naxtlevelofandroiddevelopment.marvelgallery.presentation.common.Presenter

class HeroProfilePresenter(val view: HeroProfileView, val character: MarvelCharacter) : Presenter() {

    private val htmlPoint = "&#8226;"
    private val htmlEnter = "<br/>"

    override fun onStart() {
        view.setUpCharacterImage(character.imageUrl)
        view.setUpCharacterData(
                name = character.name,
                description = character.description,
                occurrences = makeOccurrencesText()
        )
    }

    private fun makeOccurrencesText(): String {
        var occurencesText = ""

        fun addListIfNotEmpty(introductionTextId: Int, list: List<String>) {
            if (list.isEmpty()) return
            val introductionText = view.getStringById(introductionTextId)
            val htmlList = list.toHtmlList()
            occurencesText += "$introductionText $htmlEnter $htmlList $htmlEnter"
        }

        addListIfNotEmpty(R.string.occurences_comics_list_introduction, character.comics)
        addListIfNotEmpty(R.string.occurences_series_list_introduction, character.series)
        addListIfNotEmpty(R.string.occurences_stories_list_introduction, character.stories)
        addListIfNotEmpty(R.string.occurences_events_list_introduction, character.events)

        return occurencesText
    }

    private fun List<String>.toHtmlList(): String = fold("") { acc, item -> acc + "$htmlPoint $item $htmlEnter" }
}

