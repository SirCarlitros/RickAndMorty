package com.wear.example.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.wear.example.R
import com.wear.example.databinding.ActivityMainBinding
import com.wear.example.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        navController = findNavController(R.id.nav_host_fragment)

        binding.navigationBottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_characters -> {
                    Navigation.gotoCharacters(navController)
                    true
                }
                R.id.action_favorite -> {
                    Log.d("Ok_Delta_asd", mainViewModel.inteData.toString())
                    Navigation.gotoFavorite(navController)
                    true
                }
                else -> false
            }
        }

        CoroutineScope(Dispatchers.Default).launch(Dispatchers.Default) {
            for (i in (1..1000)) {
                async {
                    doSomething(i * 2L)
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
