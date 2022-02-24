package com.example.networking

import android.app.Application
import com.example.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkingModule {

    @Provides
    @ApplicationScope
    fun provideCache(
        application: Application,
        networkingConfiguration: NetworkingConfiguration
    ): Cache {
        return Cache(application.cacheDir, networkingConfiguration.cacheSize)
    }

    @Provides
    @ApplicationScope
    fun provideNetworkInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @ApplicationScope
    fun provideClient(cache: Cache, interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).cache(cache).build()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(
        client: OkHttpClient,
        networkingConfiguration: NetworkingConfiguration
    ): Retrofit {
        return Retrofit.Builder().client(client).baseUrl(networkingConfiguration.serverBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}