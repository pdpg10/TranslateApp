package com.example.translateapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.translateapp.data.Word

class WordCallback : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(
        oldItem: Word,
        newItem: Word
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Word,
        newItem: Word
    ) = oldItem == newItem
}