package com.wear.example.data.data_source

import android.content.Context
import android.util.Log
import com.wear.example.R
import com.wear.example.data.model.ApiResponseRickAndMorty
import com.wear.example.di.NumberOne
import com.wear.example.di.scopes.FragmentScope
import com.wear.example.model.data_source.RickAndMortyDataSource
import com.wear.example.network.Api
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import java.lang.Thread.sleep
import javax.inject.Inject
import javax.inject.Provider

@FragmentScope
class RickAndMortyDataSourceImpl @Inject constructor(
    private val context: Context,
    @NumberOne private val page: Provider<Int>
) :
    RickAndMortyDataSource {

    @Inject
    lateinit var retrofit: Retrofit

    private var _page: Int = 1

    init {
        sleep(1000L)
        _page = page.get()
    }

    override suspend fun getCharacters(): ApiResponseRickAndMorty? {
        Log.d("DATA_SOURCE_IMPL", "--> $this")

        val queryMap = HashMap<String, Any>()
        queryMap["page"] = _page.toString()
        _page++

        Log.d("DATA_SOURCE_RANDOM_VALUE", "${queryMap["page"]}")

        Log.d("RETROFIT_INSTANCE", "$retrofit")
        val response = retrofit.create(Api::class.java)
            .getCharacters(context.getString(R.string.base_url_rick_and_morty), query = queryMap)
        delay(1000L)
        return if (response.isSuccessful) response.body() else null

    }

}