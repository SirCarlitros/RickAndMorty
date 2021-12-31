package com.wear.example.ui.characters

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.wear.example.databinding.ActivityMainBinding
import com.wear.example.ui.characters.recycler.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )*/

        viewModel.data.observe(this, Observer {
            it ?: return@Observer

            binding.fakeShimmer.visibility = View.GONE

            binding.recyclerViewCharacters.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = RecyclerAdapter(this@MainActivity, it.results)
                visibility = View.VISIBLE
            }

            binding.swipeToRefresh.isRefreshing = false
        })

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getDataCharacters()
        }

    }
}