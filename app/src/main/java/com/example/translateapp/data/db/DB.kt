package com.example.translateapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.translateapp.data.Word

@Database(entities = [Word::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun wordDao(): WordDao
}