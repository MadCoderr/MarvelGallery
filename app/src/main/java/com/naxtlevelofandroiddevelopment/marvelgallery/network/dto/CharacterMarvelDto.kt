package com.naxtlevelofandroiddevelopment.marvelgallery.network.dto


class CharacterMarvelDto {

    var name: String? = null
    var description: String? = null
    var thumbnail: ImageDto? = null
    var comics: CharacterComicWrapper? = null
    var series: CharacterComicWrapper? = null
    var stories: CharacterComicWrapper? = null
    var events: CharacterComicWrapper? = null

    val imageUrl: String
        get() = thumbnail!!.completeImagePath
}