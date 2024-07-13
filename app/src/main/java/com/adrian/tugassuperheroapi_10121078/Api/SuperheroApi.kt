package com.adrian.tugassuperheroapi_10121078.Api

import com.adrian.tugassuperheroapi_10121078.Model.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface SuperheroApi {
    @GET("613")
    fun getSuperhero(): Call<Superhero>
}