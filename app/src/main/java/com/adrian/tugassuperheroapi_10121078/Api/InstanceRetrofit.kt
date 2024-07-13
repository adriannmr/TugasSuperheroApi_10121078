package com.adrian.tugassuperheroapi_10121078.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InstanceRetrofit {
    private const val BASE_URL = "https://www.superheroapi.com/api/29b78d2ea4db36b72dcfa124cf2722e4/"

    val api: SuperheroApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperheroApi::class.java)
    }
}