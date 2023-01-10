package com.wear.example.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.wear.example.R
import com.wear.example.applicationComponent
import com.wear.example.databinding.ActivityMainBinding
import com.wear.example.di.activity.ActivityComponent
import com.wear.example.navigation.Navigation
import kotlinx.coroutines.*
import okhttp3.internal.wait
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

        CoroutineScope(Dispatchers.Default).launch(Dispatchers.Default){
            for (i in (1..1000)) {
                async {
                    doSomething(i * 2L )
                   /* withContext(Dispatchers.IO) {
                        doSomething(i * 2L)
                    }*/
                }
            }
            doSomethingMore(5000L)
            launch {
                doSomething(4000L)
                delay(2000L)
                Log.d("Ok_", "END_REAL")
            }
            Log.d("Ok_", "END")

        }

    }

    private suspend fun doSomething(int: Long) {
        Log.d("Ok_PRE ${Thread.currentThread()}", int.toString())
        delay(int)
        Log.d("Ok_POST ${Thread.currentThread()}", int.toString())
    }

    private suspend fun doSomethingMore(int: Long) {
        Log.d("Ok_MORE ${Thread.currentThread()}", int.toString())
        delay(int)
        Log.d("Ok_MORE_POST ${Thread.currentThread()}", int.toString())
    }
}

val Context.activityComp: ActivityComponent get() = (this as MainActivity).mainActivityComponent

