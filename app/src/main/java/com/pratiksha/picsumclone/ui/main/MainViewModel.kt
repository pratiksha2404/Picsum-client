package com.pratiksha.picsumclone.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratiksha.picsumclone.data.ImageData
import com.pratiksha.picsumclone.domain.FetchImagesUseCase
import kotlinx.coroutines.launch

class MainViewModel(fetchImagesUseCase: FetchImagesUseCase) : ViewModel() {

    var imageDataListLiveData: MutableLiveData<List<ImageData>> = MutableLiveData()

    init {

        viewModelScope.launch {

            imageDataListLiveData.value = fetchImagesUseCase.execute()
        }
    }
}