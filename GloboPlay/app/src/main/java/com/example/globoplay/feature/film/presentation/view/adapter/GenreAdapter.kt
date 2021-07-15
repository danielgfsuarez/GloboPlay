package com.example.globoplay.feature.film.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globoplay.databinding.ListGenreBinding
import com.example.globoplay.feature.film.data.model.Movie
import com.example.globoplay.feature.film.data.model.MovieToGenre

class GenreAdapter : RecyclerView.Adapter<GenreAdapter.ViewHolderGenre>() {

    private val movieToGenre = ArrayList<MovieToGenre>()

    fun addMovieToGenre(list: List<MovieToGenre>) {
        movieToGenre.clear()
        movieToGenre.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGenre {
        return ViewHolderGenre(
            ListGenreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderGenre: ViewHolderGenre, position: Int) {
        val movie = movieToGenre[position]
        with(holderGenre.binding) {
            titleGenre.text = movie.name
            setListMovieToGenre(rvMovie, movie.listMovie)
        }
    }

    override fun getItemCount(): Int = movieToGenre.size

    class ViewHolderGenre(val binding: ListGenreBinding) :
        RecyclerView.ViewHolder(binding.root)

    private fun setListMovieToGenre(recyclerView: RecyclerView, list: List<Movie>) {
        val itemRecyclerView = MovieAdapter(list)
        recyclerView.layoutManager =
            LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerView
    }
}