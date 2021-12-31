package com.wear.example.network

import com.wear.example.data.model.ApiResponseRickAndMorty
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface Api {

    @GET
    suspend fun getCharacters(
        @Url url: String,
        @HeaderMap headers: HashMap<String, Any> = HashMap<String, Any>(),
        @QueryMap query: HashMap<String, Any> = HashMap<String, Any>()
    ): Response<ApiResponseRickAndMorty>
}