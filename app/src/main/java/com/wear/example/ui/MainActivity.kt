package com.wear.example.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.wear.example.R
import com.wear.example.applicationComponent
import com.wear.example.databinding.ActivityMainBinding
import com.wear.example.di.activity.ActivityComponent
import com.wear.example.navigation.Navigation
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    lateinit var mainActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityComponent =
            application.applicationComponent.activityComponentBuilder().activity(this).build()
        mainActivityComponent.injectMainActivity(this)

        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)

        binding.navigationBottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_characters -> {
                    Navigation.gotoCharacters(navController)
                    true
                }
                R.id.action_favorite -> {
                    Navigation.gotoFavorite(navController)
                    true
                }
                else -> false
            }
        }

    }
}

val Context.activityComp: ActivityComponent get() = (this as MainActivity).mainActivityComponent

