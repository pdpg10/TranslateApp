package com.example.translateapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.translateapp.data.Word
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface WordDao {
    @Insert
    fun insert(it: Word): Long

    @Query(
        """
        select * from word 
        where nameUz=:it 
    """
    )
    fun search(it: String): Maybe<List<Word>>


    @Query("select * from word")
    fun loadAll(): LiveData<List<Word>>
}