package com.example.globoplay.feature.film.data.network

import com.example.globoplay.feature.film.data.response.GenreResponse
import com.example.globoplay.feature.film.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("genre/movie/list")
    suspend fun getGenre(@Query("api_key") apiKey: String): GenreResponse

    @GET("movie/popular")
    suspend fun getMovie(@Query("api_key") apiKey: String): MovieResponse
}