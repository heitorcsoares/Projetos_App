package com.example.apimarvel.data.model

data class HeroiResponse(
    val data: InfosHeroi
)

data class InfosHeroi(
    val results: List<Heroi>
)

data class Heroi(
    val name: String,
    val description: String
)