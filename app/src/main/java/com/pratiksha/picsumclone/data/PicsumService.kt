package com.pratiksha.picsumclone.data;

import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumService {

    @GET("list")
    suspend fun getImageList(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): MutableList<ImageData>
}
