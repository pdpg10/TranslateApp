package com.example.translateapp.data.net

import com.example.translateapp.data.KEY
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("api/v1.5/tr.json/translate")
    fun search(
        @Query("text") uzText: String,
        @Query("key") key: String = KEY,
        @Query("lang") lang: String = "uz-en"
    ): Single<WordPojo>
}