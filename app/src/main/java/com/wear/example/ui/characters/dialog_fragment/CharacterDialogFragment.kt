package com.wear.example.ui.characters.dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import com.bumptech.glide.Glide
import com.wear.example.R
import com.wear.example.data.model.ResultsItem
import com.wear.example.databinding.DialogFragmentCharacterBinding
import javax.inject.Inject

class CharacterDialogFragment(
    private val resultItem: ResultsItem,
    private val listenerDialogFragment: ListenerDialogFragment
) : AppCompatDialogFragment() {

    interface ListenerDialogFragment {
        fun closeDialogFragment(characterDialogFragment: CharacterDialogFragment)
    }

    lateinit var binding: DialogFragmentCharacterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.dialog_fragment_character_style)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentCharacterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view.context).load(resultItem.image.orEmpty())
            .placeholder(R.drawable.ic_round_character).into(binding.ivImageCharacterDialogFragment)
        binding.tvNameCharacterDialogFragment.text = view.context.getString(
            R.string.name_character_dialog_fragment,
            resultItem.name.orEmpty()
        )
        binding.tvStatusCharacterDialogFragment.text = view.context.getString(
            R.string.status_character_dialog_fragment,
            resultItem.status.orEmpty()
        )
        binding.tvSpeciesCharacterDialogFragment.text = view.context.getString(
            R.string.species_character_dialog_fragment,
            resultItem.species.orEmpty()
        )
        binding.tvGenderCharacterDialogFragment.text = view.context.getString(
            R.string.gender_character_dialog_fragment,
            resultItem.gender.orEmpty()
        )
        binding.tvOriginCharacterDialogFragment.text = view.context.getString(
            R.string.origin_character_dialog_fragment,
            resultItem.origin?.name.orEmpty()
        )
        binding.tvEpisodesCharacterDialogFragment.text = view.context.getString(
            R.string.episodes_character_dialog_fragment,
            resultItem.episode?.size
        )
        binding.btnCloseCharacterDialogFragment.setOnClickListener {
            listenerDialogFragment.closeDialogFragment(this)
        }
    }

    override fun onResume() {
        super.onResume()

        val width = resources.displayMetrics.widthPixels * 0.7
        val height = width * 1.4
        dialog!!.window!!.setLayout(width.toInt(), height.toInt())
    }
}