package com.example.translateapp.data

import io.reactivex.Maybe
import io.reactivex.Single

interface IRepository {
    fun search(searchedWord: String): Maybe<List<Word>>
}