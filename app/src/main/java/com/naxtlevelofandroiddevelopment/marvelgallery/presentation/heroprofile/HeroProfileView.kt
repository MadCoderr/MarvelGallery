package com.naxtlevelofandroiddevelopment.marvelgallery.presentation.heroprofile;

interface HeroProfileView {
    fun setUpCharacterImage(photoUrl: String)
    fun setUpCharacterData(name: String, description: String, occurrences: String)
    fun getStringById(id: Int): String
}