package com.wear.example.ui.characters.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wear.example.R
import com.wear.example.data.model.ResultsItem
import com.wear.example.ui.characters.dialog_fragment.CharacterDialogFragment

class RecyclerAdapter(private val context: Context, private val dataSet: List<ResultsItem?>?, private val parentFragment: FragmentManager) :
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
            resultItem.image?.let {url ->
                Glide.with(context).load(url).into(holder.imageView)
            }
            holder.nameField.text = resultItem.name

            holder.container.setOnClickListener {
                CharacterDialogFragment(resultItem).show(parentFragment,DIALOG_FRAGMENT_CHARACTER)
            }
        }
    }

    override fun getItemCount() = dataSet?.size ?: 0

}