package com.example.networking

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    @Singleton
    fun provideCache(
        application: Application,
        networkingConfiguration: NetworkingConfiguration
    ): Cache {
        return Cache(application.cacheDir, networkingConfiguration.cacheSize)
    }

    @Provides
    @Singleton
    fun provideNetworkInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideClient(cache: Cache, interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).cache(cache).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        networkingConfiguration: NetworkingConfiguration
    ): Retrofit {
        return Retrofit.Builder().client(client).baseUrl(networkingConfiguration.serverBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}