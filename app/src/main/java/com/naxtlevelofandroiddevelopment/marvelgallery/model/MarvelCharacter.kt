package com.naxtlevelofandroiddevelopment.marvelgallery.model

import com.naxtlevelofandroiddevelopment.marvelgallery.network.dto.CharacterMarvelDto
import nz.bradcampbell.paperparcel.PaperParcel
import nz.bradcampbell.paperparcel.PaperParcelable

@PaperParcel
data class MarvelCharacter(
        val name: String,
        val imageUrl: String,
        val description: String,
        val comics: List<String>,
        val series: List<String>,
        val stories: List<String>,
        val events: List<String>
) : PaperParcelable {

    constructor(dto: CharacterMarvelDto) : this(
            name = dto.name ?: "",
            imageUrl = dto.imageUrl,
            description = dto.description ?: "",
            comics = dto.comics?.items?.mapNotNull { it.name }.orEmpty(),
            series = dto.series?.items?.mapNotNull { it.name }.orEmpty(),
            stories = dto.stories?.items?.mapNotNull { it.name }.orEmpty(),
            events = dto.events?.items?.mapNotNull { it.name }.orEmpty()
    )

    companion object {
        @JvmField val CREATOR = PaperParcelable.Creator(MarvelCharacter::class.java)
    }
}