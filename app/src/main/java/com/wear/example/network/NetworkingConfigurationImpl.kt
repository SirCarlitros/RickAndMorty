package com.wear.example.network

import com.example.networking.NetworkingConfiguration
import com.example.scope.ApplicationScope
import com.wear.example.App
import com.wear.example.R
import javax.inject.Inject

@ApplicationScope
class NetworkingConfigurationImpl @Inject constructor()  : NetworkingConfiguration {
    override val cacheSize: Long
    get() = 100 * 1_024L
    override val serverBaseUrl: String
    get() = App.app.getString(R.string.base_url_rick_and_morty)
}