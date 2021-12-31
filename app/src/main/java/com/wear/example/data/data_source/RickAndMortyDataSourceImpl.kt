package com.wear.example.data.data_source

import android.util.Log
import com.wear.example.data.model.ApiResponseRickAndMorty
import com.wear.example.model.data_source.RickAndMortyDataSource
import com.wear.example.network.Api
import com.wear.example.network.RetrofitInstance
import kotlinx.coroutines.delay

class RickAndMortyDataSourceImpl : RickAndMortyDataSource {


    private val retrofit = RetrofitInstance.getRetrofitInstance()

    override suspend fun getCharacters(page: Int?): ApiResponseRickAndMorty? {
        Log.d("DATA_SOURCE_IMPL", "--> $this")
        val queryMap = HashMap<String, Any>()
        if (page != null) queryMap["page"] = page.toString()
        val response = retrofit.create(Api::class.java)
            .getCharacters("https://rickandmortyapi.com/api/character/", query = queryMap)
        delay(3000L)
        return if (response.isSuccessful) response.body() else null

    }

}