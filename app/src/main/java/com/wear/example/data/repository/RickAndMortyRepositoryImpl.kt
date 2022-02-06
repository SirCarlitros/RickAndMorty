package com.wear.example.data.repository

import android.util.Log
import com.wear.example.data.model.ApiResponseRickAndMorty
import com.wear.example.di.scopes.FragmentScope
import com.wear.example.model.data_source.RickAndMortyDataSource
import com.wear.example.model.repository.RickAndMortyRepository
import java.util.*
import javax.inject.Inject

@FragmentScope
class RickAndMortyRepositoryImpl @Inject constructor() :
    RickAndMortyRepository {

    @set:Inject
    var dataSourceImpl: Optional<RickAndMortyDataSource> = Optional.empty()

    override suspend fun getCharacters(): ApiResponseRickAndMorty? {
        Log.d("REPOSITORY_IMPL", "--> $this")
        return if(dataSourceImpl.isPresent) dataSourceImpl.get().getCharacters() else null
    }
}