package com.wear.example.model.repository

import com.wear.example.data.model.ApiResponseRickAndMorty

interface RickAndMortyRepository {

    suspend fun getCharacters(): ApiResponseRickAndMorty?
}