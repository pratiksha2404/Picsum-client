package com.pratiksha.picsumclone.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pratiksha.picsumclone.data.ImageData
import com.pratiksha.picsumclone.domain.FetchImagesUseCase

class MainViewModel(fetchImagesUseCase: FetchImagesUseCase) : ViewModel() {

    var imageDataListLiveData: MutableLiveData<List<ImageData>> = MutableLiveData()

    init {
        imageDataListLiveData.value = fetchImagesUseCase.execute()
    }
}