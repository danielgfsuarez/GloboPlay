package com.example.globoplay.feature.film.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globoplay.databinding.ActivityMovielistBinding
import com.example.globoplay.feature.film.presentation.view.adapter.GenreAdapter
import com.example.globoplay.feature.film.presentation.viewmodel.MovieListViewModel
import com.example.globoplay.feature.film.data.mapper.MovieMapper

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovielistBinding

    private lateinit var recyclerViewGenre: RecyclerView
    private lateinit var viewModel: MovieListViewModel
    private val adapterGenre = GenreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovielistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        init()
    }

    private fun init() {
        viewBind()
        setupViewModel()
        setupActionBar()
        setupRecyclerGenre()
        viewModel.getMovieByGenre()
    }

    private fun setupActionBar() {
        supportActionBar?.hide()
    }

    private fun setupRecyclerGenre() {
        recyclerViewGenre.run {
            layoutManager =
                LinearLayoutManager(this@MovieListActivity, RecyclerView.VERTICAL, false)
            adapter = adapterGenre
        }
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(
                this,
                MovieListViewModel.MovieListViewModelFactory(MovieMapper())
            ).get(
                MovieListViewModel::class.java
            )
        viewModel.movieByGenreLiveData.observe(this) {
            adapterGenre.addMovieToGenre(it)
        }
    }

    private fun viewBind() {
        recyclerViewGenre = binding.rvHomeGenre
    }
}