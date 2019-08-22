package com.example.translateapp.data

import io.reactivex.Maybe

interface IRepository {
    fun search(searchedWord: String): Maybe<List<Word>>
}