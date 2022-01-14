package com.pratiksha.picsumclone.data

class ImageRepository {

    fun fetchImages(): List<ImageData> {
        val imageData = ImageData("123", "qwdq", 1, 2,"1231", "1231")

        //TODO: use retrofit to make actual api call and return data
        return listOf(imageData, imageData, imageData)
    }

}
