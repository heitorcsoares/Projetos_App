package com.example.apimarvel.data

import com.example.apimarvel.data.model.HeroiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//Documentação->  RETROFIT • https://square.github.io/retrofit/

interface MarvelAPI {
    @GET("v1/public/characters")
    fun buscarHeroiPorNome(
        @Query("name") name: String,
        @Query("apikey") apikey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ): Call<HeroiResponse>
}