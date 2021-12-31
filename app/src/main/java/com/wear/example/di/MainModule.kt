package com.wear.example.di

import com.wear.example.data.data_source.RickAndMortyDataSourceImpl
import com.wear.example.data.repository.RickAndMortyRepositoryImpl
import com.wear.example.model.data_source.RickAndMortyDataSource
import com.wear.example.model.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [BindModule::class])
object MainModule {

    @Provides
    fun provideDataSource(): RickAndMortyDataSource = RickAndMortyDataSourceImpl()

    @Module
    interface Bindings{

        @Binds
        fun provideRepository(rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl): RickAndMortyRepository
    }
}