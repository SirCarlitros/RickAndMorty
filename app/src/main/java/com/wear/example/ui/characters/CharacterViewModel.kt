package com.wear.example.ui.characters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wear.example.R
import com.wear.example.data.model.ApiResponseRickAndMorty
import com.wear.example.model.repository.RickAndMortyRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class CharacterViewModel @Inject constructor() : ViewModel() {

    private val _data = MutableLiveData<ApiResponseRickAndMorty?>(null)
    val data: LiveData<ApiResponseRickAndMorty?> get() = _data

    private val _scrollState = MutableLiveData<Int>()
    val scrollState : LiveData<Int> get() = _scrollState

    @SuppressLint("StaticFieldLeak")
    private var context: Context? = null

    @Inject
    lateinit var repositoryImpl: RickAndMortyRepository

    @Inject
    fun setContextViewModel(context: Provider<Context>){
        this.context = context.get()
    }

    fun getDataCharacters() {
        try {
            Log.d("REPO_SA", repositoryImpl.toString())
            context?.getString(R.string.app_name)?.let { Log.d("REPO_SA", it) }
            viewModelScope.launch {
                _data.value = repositoryImpl.getCharacters()
            }
        } catch (e: Exception) {
            _data.value = null
        }

    }

    fun setScrollState(value: Int){
        _scrollState.value = value
    }
}