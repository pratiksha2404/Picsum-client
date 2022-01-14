package com.pratiksha.picsumclone.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pratiksha.picsumclone.domain.FetchImagesUseCase

class MainViewModelFactory(private val fetchImagesUseCase: FetchImagesUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(fetchImagesUseCase) as T
        }
        else
        {
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}