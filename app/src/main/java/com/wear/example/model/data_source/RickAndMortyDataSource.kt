package com.wear.example.model.data_source

import com.wear.example.data.model.ApiResponseRickAndMorty

interface RickAndMortyDataSource {

    suspend fun getCharacters(): ApiResponseRickAndMorty?
}