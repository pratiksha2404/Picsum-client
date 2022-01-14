package com.pratiksha.picsumclone.data

data class ImageData(
    private val id: String,
    private val author: String,
    private val width: Int,
    private val height: Int,
    private val url: String,
    private val download_url: String?
)
