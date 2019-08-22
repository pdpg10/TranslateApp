package com.example.translateapp.data

import android.annotation.SuppressLint
import com.example.translateapp.data.db.WordDao
import com.example.translateapp.data.net.Api
import io.reactivex.Maybe

class RepoImpl(
    private val api: Api,
    private val dao: WordDao
) : IRepository {
    @SuppressLint("CheckResult")
    override fun search(searchedWord: String): Maybe<List<Word>> {

        val db: Maybe<List<Word>> = dao.search(searchedWord)
        val rest: Maybe<List<Word>> = api.search(searchedWord)
            .map { it ->
                val list = mutableListOf<Word>()
                it.text.forEach {
                    Word(searchedWord, it).apply {
                        dao.insert(this)
                        list += this
                    }
                }
                list.toList()
            }.toMaybe()
        return db.switchIfEmpty(rest)
    }
}