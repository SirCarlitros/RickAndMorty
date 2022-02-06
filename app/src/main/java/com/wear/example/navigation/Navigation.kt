package com.wear.example.navigation

import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import com.wear.example.ui.MainActivity
import com.wear.example.ui.characters.CharacterFragmentDirections

class Navigation {

    companion object {

        fun gotoFavorite(navController: NavController) {
            navController.navigate(CharacterFragmentDirections.actionCharactersFragmentToFavoritesFragment())
        }

        fun gotoCharacters(navController: NavController) {
            navController.navigateUp()
        }

        fun gotoMainActivity(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }

    }
}