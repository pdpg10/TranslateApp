package com.example.translateapp.data.net

import com.example.translateapp.data.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {
    companion object {
        private var instance: Api? = null
        fun instance(): Api {
            val localIns = instance
            if (localIns == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val it = retrofit.create(Api::class.java)
                this.instance = it
                return it
            }
            return localIns
        }
    }
}