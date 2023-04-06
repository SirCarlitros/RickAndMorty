package com.wear.example.ui.characters

import android.util.Log
import androidx.lifecycle.*
import com.wear.example.data.model.ApiResponseRickAndMorty
import com.wear.example.model.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repositoryImpl: RickAndMortyRepository
) : ViewModel() {

    private val _data = MutableLiveData<ApiResponseRickAndMorty?>(null)
    val data: LiveData<ApiResponseRickAndMorty?> get() = _data

    private val _scrollState = MutableLiveData<Int>()
    val scrollState: LiveData<Int> get() = _scrollState


    fun getDataCharacters() {
        try {
            Log.d("REPO_SA", repositoryImpl.toString())
            val delta : Int = savedStateHandle["count"] ?: 80
            Log.d("Ok_Delta", delta.toString())
            viewModelScope.launch {
                _data.value = repositoryImpl.getCharacters()
            }
        } catch (e: Exception) {
            _data.value = null
        }

    }

    fun setScrollState(value: Int) {
        _scrollState.value = value
    }
}