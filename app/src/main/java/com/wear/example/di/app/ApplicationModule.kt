package com.wear.example.di.app

import com.example.networking.NetworkingConfiguration
import com.wear.example.network.NetworkingConfigurationImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
interface ApplicationModule {

    @Binds
    fun bindNetworkingConfiguration(networkingConfiguration: NetworkingConfigurationImpl): NetworkingConfiguration
}