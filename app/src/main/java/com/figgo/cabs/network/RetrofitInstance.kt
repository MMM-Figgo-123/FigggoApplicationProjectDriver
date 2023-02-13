package com.figgo.cabs.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        fun getRetrofitInstance(): Retrofit {
            return  Retrofit.Builder()
                .baseUrl(FIGGO_URLS.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}