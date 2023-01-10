package com.wear.example.ui.characters.recycler

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.core.view.updateLayoutParams
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wear.example.R
import com.wear.example.data.model.ResultsItem
import com.wear.example.ui.characters.dialog_fragment.CharacterDialogFragment

class RecyclerAdapter(
    private val context: Context,
    private val dataSet: List<ResultsItem?>?,
    private val parentFragment: FragmentManager
) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    companion object {
        const val DIALOG_FRAGMENT_CHARACTER = "DIALOG_FRAGMENT_CHARACTER"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        dataSet?.get(position)?.let { resultItem ->
            holder.character = resultItem
            resultItem.image?.let { url ->
                Glide.with(context).load(url).into(holder.imageView)
            }


            holder.nameField.text = resultItem.name
            if (position == 1) holder.nameField.text =
                "ESta es una prueba de como puede ser el nombre"

            holder.nameField.updateLayoutParams {
                if (holder.nameField.text.length > 20) width = 0
            }

            holder.container.setOnClickListener {
                CharacterDialogFragment(resultItem).show(parentFragment, DIALOG_FRAGMENT_CHARACTER)
            }
        }
    }


    override fun getItemCount() = dataSet?.size ?: 0

}