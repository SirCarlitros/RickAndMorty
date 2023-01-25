package com.wear.example.di.fragment

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.wear.example.data.data_source.RickAndMortyDataSourceImpl
import com.wear.example.data.repository.RickAndMortyRepositoryImpl
import com.wear.example.databinding.DialogFragmentCharacterBinding
import com.wear.example.databinding.FragmentCharactersBinding
import com.wear.example.di.NumberOne
import com.wear.example.di.NumberTwo
import com.wear.example.model.data_source.RickAndMortyDataSource
import com.wear.example.model.repository.RickAndMortyRepository
import com.wear.example.ui.MainActivity
import com.wear.example.ui.characters.dialog_fragment.CharacterDialogFragment
import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module(includes = [FragmentModule.View::class, FragmentModule.Binding::class, FragmentModule.NumberModule::class])
@InstallIn(dagger.hilt.android.components.FragmentComponent::class)
class FragmentModule {

    @Provides
    fun provideContext(activity: Activity): Context = activity

    @Module
    @InstallIn(dagger.hilt.android.components.FragmentComponent::class)
    class View {


        @Provides
        fun provideDialogFragmentCharactersBinding(activity: Activity): DialogFragmentCharacterBinding {
            return DialogFragmentCharacterBinding.inflate((activity as MainActivity).layoutInflater)
        }

        @Provides
        fun provideCharacterListenerDialogFragment(fragment: Fragment): CharacterDialogFragment.ListenerDialogFragment =
            fragment as CharacterDialogFragment.ListenerDialogFragment

    }

    @Module
    @InstallIn(dagger.hilt.android.components.ViewModelComponent::class)
    abstract class Binding {

        @BindsOptionalOf
        abstract fun provideRickAndMortyDataSourceOptional(): RickAndMortyDataSource

        @Binds
        abstract fun bindRickAndMortyDataSource(rickAndMortyDataSourceImpl: RickAndMortyDataSourceImpl): RickAndMortyDataSource

        @Binds
        abstract fun bindRickAndMortyRepository(rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl): RickAndMortyRepository

    }

    @Module
    @InstallIn(ViewModelComponent::class)
    class NumberModule() {

        @Provides
        @Named("count")
        fun provideCount(savedStateHandle: SavedStateHandle): Int {
            return savedStateHandle.get<Int>("count")?: 0
        }

        @Provides
        @NumberOne
        fun provideIntegerOne(): Int = 1

        @Provides
        @NumberTwo
        fun provideIntegerTwo(): Int = 2
    }

}