package com.naxtlevelofandroiddevelopment.marvelgallery.network.dto

class ImageDto {

    var path: String? = null
    var extension: String? = null

    val completeImagePath: String
        get() = "$path.$extension"
}