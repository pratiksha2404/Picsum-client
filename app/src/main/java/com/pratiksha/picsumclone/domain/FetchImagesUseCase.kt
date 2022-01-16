package com.pratiksha.picsumclone.domain

import com.pratiksha.picsumclone.data.ImageData
import com.pratiksha.picsumclone.data.ImageRepository

class FetchImagesUseCase(private val imageRepository: ImageRepository) {

    suspend fun execute(): List<ImageData> {

        return imageRepository.fetchImages()
    }
}