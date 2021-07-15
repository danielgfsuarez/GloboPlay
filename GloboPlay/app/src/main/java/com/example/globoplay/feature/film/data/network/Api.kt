package com.example.globoplay.feature.film.data.network

import com.example.globoplay.helper.ApiRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    fun theMovieDB(): Service {
        return Retrofit.Builder()
            .baseUrl(ApiRequest.MOVIESERVICE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build())
            .build().create(Service::class.java)
    }

}