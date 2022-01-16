package com.pratiksha.picsumclone.domain

import com.pratiksha.picsumclone.data.ImageData
import com.pratiksha.picsumclone.data.ImageRepository
import com.pratiksha.picsumclone.data.ImageRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class FetchImagesUseCaseTest {

    class FakeImageRepositoryImpl : ImageRepository{

        override fun fetchImages(): List<ImageData> {
            val imageData = ImageData("123", "qwdq", 1, 2,"1231", "1231")
            return listOf(imageData, imageData, imageData)
        }

    }
    lateinit var SUT: FetchImagesUseCase

    @Before
    fun setUp() {
        SUT = FetchImagesUseCase(FakeImageRepositoryImpl())
    }

    @Test
    fun `when repository return some data, return back the same data to calling function`(){

    }
    @Test
    fun `when repository returns exception, check whether retry logic works`(){

    }

    @After
    fun tearDown() {

    }


}