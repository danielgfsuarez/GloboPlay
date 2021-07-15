package com.example.globoplay.feature.film.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.globoplay.feature.film.data.model.MovieToGenre
import com.example.globoplay.feature.film.data.mapper.MovieMapper
import kotlinx.coroutines.launch

class MovieListViewModel(private val mapper: MovieMapper) : ViewModel() {

    val movieByGenreLiveData = MutableLiveData<List<MovieToGenre>>()

    fun getMovieByGenre() {
        viewModelScope.launch {
            movieByGenreLiveData.postValue(mapper.getMovieByGenre())
        }
    }

    class MovieListViewModelFactory(private val mapper: MovieMapper) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieListViewModel(mapper) as T
        }
    }
}