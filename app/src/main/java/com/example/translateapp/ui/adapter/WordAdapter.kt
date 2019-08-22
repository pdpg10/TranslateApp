package com.example.translateapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.translateapp.R
import com.example.translateapp.data.Word
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_word.*

class WordAdapter(ctx: Context) : ListAdapter<Word, WordAdapter.VH>(WordCallback()) {
    private val inflater = LayoutInflater.from(ctx)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = inflater.inflate(R.layout.item_word, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val word = getItem(position)
        holder.onBind(word)
    }

    class VH(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun onBind(it: Word) {
            tv.text = it.nameEng
        }
    }
}