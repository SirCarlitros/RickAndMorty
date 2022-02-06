package com.wear.example.ui.characters.recycler

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.wear.example.R
import com.wear.example.data.model.ResultsItem

class RecyclerViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    val container: ConstraintLayout = view.findViewById(R.id.cl_container_rv_character)
    val imageView: AppCompatImageView = view.findViewById(R.id.iv_image_character)
    val nameField: AppCompatTextView = view.findViewById(R.id.tv_name_character)
    var character: ResultsItem? = null

}
