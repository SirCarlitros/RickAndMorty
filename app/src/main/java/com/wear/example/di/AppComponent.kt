package com.wear.example.di

import com.wear.example.ui.characters.MainActivityViewModel
import dagger.Component

@Component(modules = [MainModule::class])
interface AppComponent {

    fun injectViewModel(viewModel: MainActivityViewModel)
}