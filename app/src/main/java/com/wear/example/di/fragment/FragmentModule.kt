package com.wear.example.di.fragment

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
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

@Module(includes = [FragmentModule.View::class, FragmentModule.Binding::class, FragmentModule.NumberModule::class])
class FragmentModule {

    @Provides
    fun provideContext(activity: Activity): Context = activity

    @Module
    class View {

        @Provides
        fun provideCharacterFragmentBinding(activity: Activity) =
            FragmentCharactersBinding.inflate((activity as MainActivity).layoutInflater)

        @Provides
        fun provideDialogFragmentCharactersBinding(activity: Activity): DialogFragmentCharacterBinding {
            return DialogFragmentCharacterBinding.inflate((activity as MainActivity).layoutInflater)
        }

        @Provides
        fun provideCharacterListenerDialogFragment(fragment: Fragment): CharacterDialogFragment.ListenerDialogFragment =
            fragment as CharacterDialogFragment.ListenerDialogFragment

    }

    @Module
    interface Binding {

        @BindsOptionalOf
        fun provideRickAndMortyDataSourceOptional(): RickAndMortyDataSource

        @Binds
        fun bindRickAndMortyDataSource(rickAndMortyDataSourceImpl: RickAndMortyDataSourceImpl): RickAndMortyDataSource

        @Binds
        fun bindRickAndMortyRepository(rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl): RickAndMortyRepository

    }

    @Module
    class NumberModule() {

        @Provides
        @NumberOne
        fun provideIntegerOne(): Int = 1

        @Provides
        @NumberTwo
        fun provideIntegerTwo(): Int = 2
    }

}