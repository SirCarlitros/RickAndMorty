package com.wear.example.ui.characters.recycler

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.wear.example.R

class RecyclerViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    val imageView = view.findViewById<AppCompatImageView>(R.id.iv_image_character)
    val nameField = view.findViewById<AppCompatTextView>(R.id.tv_name_character)

}
