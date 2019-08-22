package com.example.translateapp.data.db

import android.content.Context
import androidx.room.Room

class DbProvider {
    companion object {
        private var instance: WordDao? = null
        fun instance(context: Context): WordDao {
            val localIns = instance
            if (localIns == null) {
                val db = Room
                    .databaseBuilder(context, DB::class.java, "store.db")
                    .build()
                this.instance = db.wordDao()
                return instance!!
            }
            return localIns
        }
    }
}