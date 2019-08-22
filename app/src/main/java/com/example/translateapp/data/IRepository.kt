package com.example.translateapp.data

import io.reactivex.Single

interface IRepository {
    fun search(searchedWord: String): Single<Word>
}