package com.wear.example.di

import com.wear.example.data.repository.RickAndMortyRepositoryImpl
import com.wear.example.model.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindModule {

    @Binds
    abstract fun asd(rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl): RickAndMortyRepository
}