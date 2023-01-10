package com.wear.example.di.fragment

import androidx.fragment.app.Fragment
import com.example.scope.FragmentScope
import com.wear.example.ui.characters.CharacterFragment
import com.wear.example.ui.characters.ViewModelFactory
import com.wear.example.ui.characters.dialog_fragment.CharacterDialogFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [FragmentModule::class]
)
@FragmentScope
interface FragmentComponent {

    fun injectFactoryViewModelCharacter(): ViewModelFactory
    fun injectFragmentCharacter(fragmentCharacter: CharacterFragment)
    fun injectCharacterDialogFragment(characterDialogFragment: CharacterDialogFragment)

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment
        ): FragmentComponent
    }

}