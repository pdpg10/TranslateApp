package com.example.translateapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    val nameUz: String,
    val nameEng: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)