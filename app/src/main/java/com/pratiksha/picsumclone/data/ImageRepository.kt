package com.pratiksha.picsumclone.data

interface ImageRepository {
    suspend fun fetchImages(): List<ImageData>
}

class ImageRepositoryImpl(val picsumService: PicsumService) : ImageRepository {

    override suspend fun fetchImages(): List<ImageData> {

        return picsumService.getImageList(0, 0)
    }

}
