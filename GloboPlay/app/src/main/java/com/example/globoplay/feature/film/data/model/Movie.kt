package com.example.globoplay.feature.film.data.model

data class Movie(
    val id: String,
    val name: String,
    val genre: List<Int>,
    val image: String
)