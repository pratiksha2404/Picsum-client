package com.pratiksha.picsumclone.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pratiksha.picsumclone.data.ImageRepository
import com.pratiksha.picsumclone.data.ImageRepositoryImpl
import com.pratiksha.picsumclone.data.PicsumService
import com.pratiksha.picsumclone.databinding.MainFragmentBinding
import com.pratiksha.picsumclone.domain.FetchImagesUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFragment : Fragment() {

    companion object {
        private val TAG: String = MainFragment::class.java.name

        fun newInstance() = MainFragment()
    }

    private val retrofit = Retrofit.Builder().baseUrl("https://picsum.photos/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    private val picsumService = retrofit.create(PicsumService::class.java)

    private val imageRepository = ImageRepositoryImpl(picsumService)
    private val fetchImagesUseCase = FetchImagesUseCase(imageRepository)

    private lateinit var viewModel: MainViewModel
    private lateinit var mainFragmentBinding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        return mainFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(fetchImagesUseCase)
        ).get(MainViewModel::class.java)

        viewModel.imageDataListLiveData.observe(viewLifecycleOwner, Observer { imageDataList ->
            Log.d(TAG, "onViewCreated: $imageDataList")
        })
    }

}

