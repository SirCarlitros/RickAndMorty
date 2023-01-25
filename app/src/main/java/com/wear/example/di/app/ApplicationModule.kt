package com.wear.example.di.app

import com.example.networking.NetworkingConfiguration
import com.wear.example.network.NetworkingConfigurationImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
interface ApplicationModule {

    @Binds
    fun bindNetworkingConfiguration(networkingConfiguration: NetworkingConfigurationImpl): NetworkingConfiguration
}