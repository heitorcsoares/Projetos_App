package com.example.apimarvel.data

import com.example.apimarvel.data.model.HeroiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroiMarvelRepository {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buscarHeroiPorNome(nome: String, sucesso: (HeroiResponse) -> Unit, erro: () -> Unit){
        val api = retrofit.create(MarvelAPI::class.java)

        api.buscarHeroiPorNome(nome, KEY, TIMESTAMP, HASH).enqueue(
            object:  Callback<HeroiResponse> {
                override fun onResponse(
                    call: Call<HeroiResponse>?,
                    response: Response<HeroiResponse>
                ) {
                    if (response.isSuccessful) {
                        sucesso(response.body()!!)
                    } else {
                        erro()
                    }
                }

                override fun onFailure(call: Call<HeroiResponse>, t: Throwable) {
                    erro()
                }
            }
        )
    }

    /**
     * GERAR HAS:   https://www.md5hashgenerator.com/
     * GET:  https://developer.marvel.com/docs#!/public/getCreatorCollection_get_0
     * Credenciais:  https://developer.marvel.com/account
     * Texte API:  https://web.postman.co/workspace/My-Workspace~c714b31d-48bf-49b5-8b97-9033a3f14cc8/request/create?requestId=481a4797-8591-4c12-9e3b-95be7ea60868
     * */
    companion object {
        val KEY = "53333f7a16c0255092d5cc67c9aa791d"
        val TIMESTAMP = "1660260465"
        val HASH = "c809eb5202f00375c435faaf8ab75859"
    }
}