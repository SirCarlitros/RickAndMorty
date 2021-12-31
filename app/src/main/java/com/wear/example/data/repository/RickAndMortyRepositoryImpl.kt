package com.wear.example.data.repository

import android.util.Log
import com.wear.example.data.model.ApiResponseRickAndMorty
import com.wear.example.model.data_source.RickAndMortyDataSource
import com.wear.example.model.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor() :
    RickAndMortyRepository {

    @Inject
    lateinit var dataSourceImpl: RickAndMortyDataSource

    override suspend fun getCharacters(): ApiResponseRickAndMorty?{
        Log.d("REPOSITORY_IMPL", "--> $this")
        return dataSourceImpl.getCharacters((1..10).random())
    }
}