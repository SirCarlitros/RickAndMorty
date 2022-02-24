package com.wear.example.di.fragment

import com.example.scope.FragmentScope
import com.wear.example.ui.characters.CharacterFragment
import com.wear.example.ui.characters.ViewModelFactory
import com.wear.example.ui.characters.dialog_fragment.CharacterDialogFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [FragmentModule::class]
)
@FragmentScope
interface FragmentComponent {

    fun injectFactoryViewModelCharacter(): ViewModelFactory
    fun injectFragmentCharacter(fragmentCharacter: CharacterFragment)
    fun injectCharacterDialogFragment(characterDialogFragment: CharacterDialogFragment)

/*    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance activity: Activity
        ): FragmentComponent
    }*/

}