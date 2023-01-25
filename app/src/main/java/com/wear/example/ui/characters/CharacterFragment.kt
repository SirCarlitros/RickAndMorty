package com.wear.example.ui.characters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.wear.example.databinding.FragmentCharactersBinding
import com.wear.example.di.NumberTwo
import com.wear.example.ui.characters.dialog_fragment.CharacterDialogFragment
import com.wear.example.ui.characters.recycler.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class CharacterFragment : Fragment(),
    CharacterDialogFragment.ListenerDialogFragment {

    lateinit var binding: FragmentCharactersBinding

    @Inject
    @NumberTwo
    lateinit var integer: Provider<Int>

    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TEST_FACTORY_A", integer.get().toString())

/*        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )*/

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.data.observe(viewLifecycleOwner, Observer {
            binding.swipeToRefresh.isRefreshing = false

            it ?: run {
                viewModel.getDataCharacters()
                Log.d("VIEW_MODEL_INSTANCE", "$viewModel")
                return@Observer
            }

            showLoadingLayout(false)
            binding.recyclerViewCharacters.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = RecyclerAdapter(requireContext(), it.results, childFragmentManager,this@CharacterFragment)
            }

        })

        binding.swipeToRefresh.setOnRefreshListener {
            showLoadingLayout(true)
            viewModel.getDataCharacters()
        }

        binding.scrollViewCharacters.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            viewModel.setScrollState(scrollY)
        }

    }

    private fun showLoadingLayout(show: Boolean) {

        binding.swipeToRefresh.visibility = if (show) View.GONE else View.VISIBLE
        binding.fakeShimmer.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun closeDialogFragment(characterDialogFragment: CharacterDialogFragment) {
        Log.d("CHARACTER_FRAGMENT", "$this")
        characterDialogFragment.dialog?.cancel()
    }
}