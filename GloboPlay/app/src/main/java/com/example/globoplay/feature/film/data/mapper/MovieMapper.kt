package com.example.globoplay.feature.film.data.mapper

import com.example.globoplay.feature.film.data.model.Genre
import com.example.globoplay.feature.film.data.model.Movie
import com.example.globoplay.feature.film.data.model.MovieToGenre
import com.example.globoplay.feature.film.data.network.Api
import com.example.globoplay.helper.ApiRequest

class MovieMapper {

    private val service = Api.theMovieDB()
    private val movies = ArrayList<MovieToGenre>()
    private suspend fun getGenre(): List<Genre> {
        return service.getGenre(ApiRequest.APIKEY)
            .genres
            .map {
                Genre(it.id, it.name)
            }
    }

    private suspend fun getMovie(): List<Movie> {
        return service.getMovie(ApiRequest.APIKEY)
            .results
            .map {
                Movie(it.id.toString(), it.title, it.genreIds, it.posterPath)
            }
    }

    private fun selectMovieToGenre(
        listGenre: List<Genre>,
        listMovie: List<Movie>,
        id: Int
    ): MutableList<Movie> {
        val movies: MutableList<Movie> = ArrayList()
        repeat(listGenre.size) {
            listMovie.forEach { movie ->
                movie.genre.forEach {
                    if (it == id) {
                        movies.add(Movie(movie.id, movie.name, movie.genre, movie.image))
                    }
                }
            }
            return movies
        }
        return movies
    }

    suspend fun getMovieByGenre(): ArrayList<MovieToGenre> {
        getGenre().forEach { genre ->
            movies.add(
                MovieToGenre(
                    genre.id,
                    genre.name,
                    selectMovieToGenre(getGenre(), getMovie(), genre.id)
                )
            )
        }
        return movies
    }

}