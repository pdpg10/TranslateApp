package com.example.translateapp.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.translateapp.data.IRepository
import com.example.translateapp.data.RepoImpl
import com.example.translateapp.data.Word
import com.example.translateapp.data.db.DbProvider
import com.example.translateapp.data.net.ApiProvider
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WordVm : ViewModel() {
    private val api by lazy(LazyThreadSafetyMode.NONE) { ApiProvider.instance() }

    fun searchWord(context: Context, it: String): Maybe<List<Word>> {
        val dao = DbProvider.instance(context)
        val repo: IRepository = RepoImpl(api, dao)//todo every time init

        return repo.search(it)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}