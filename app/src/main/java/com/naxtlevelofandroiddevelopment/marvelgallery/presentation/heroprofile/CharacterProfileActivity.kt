package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.heroprofile;

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import com.naxtlevelofandroiddevelopment.marvelgallery.R;
import com.naxtlevelofandroiddevelopment.marvelgallery.model.MarvelCharacter
import com.naxtlevelofandroiddevelopment.marvelgallery.presentation.common.*
import kotlinx.android.synthetic.main.activity_hero_profile.*

class CharacterProfileActivity : PresenterBaseActivity(), HeroProfileView {

    val character: MarvelCharacter by extra(CHARACTER_ARG)

    override val presenter by lazy { HeroProfilePresenter(this, character) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_profile)
        setUpToolbar()
        headerView.loadImageCenterCropped(character.imageUrl)
        descriptionView.text = character.description
        occurencesView.setHtmlText(presenter.makeOccurencesText())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when {
        item.itemId == android.R.id.home -> onBackPressed().let { true }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setUpToolbar() {
        toolbar.title = character.name
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun getStringById(id: Int) = getString(id) ?: throw Error("No string with such id")

    companion object {

        val CHARACTER_ARG = "com.naxtlevelofandroiddevelopment.marvelgallery.presentation.heroprofile.CharacterArgKey"

        fun start(context: Context, character: MarvelCharacter) {
            val intent = context.getIntent<CharacterProfileActivity>().apply {
                putExtra(CHARACTER_ARG, character)
            }
            context.startActivity(intent)
        }
    }
}
