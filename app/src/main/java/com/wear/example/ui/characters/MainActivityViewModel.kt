package com.wear.example.ui.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wear.example.App
import com.wear.example.data.model.ApiResponseRickAndMorty
import com.wear.example.di.DaggerAppComponent
import com.wear.example.model.repository.RickAndMortyRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel : ViewModel() {

    private val _data = MutableLiveData<ApiResponseRickAndMorty>()
    val data: LiveData<ApiResponseRickAndMorty> get() = _data

    @Inject
    lateinit var repositoryImpl: RickAndMortyRepository

    init {
        DaggerAppComponent.create().injectViewModel(this)
    }

    fun getDataCharacters() {
        Log.d("REPO_SA", repositoryImpl.toString())
        viewModelScope.launch {
            _data.value = repositoryImpl.getCharacters()
        }
    }

}