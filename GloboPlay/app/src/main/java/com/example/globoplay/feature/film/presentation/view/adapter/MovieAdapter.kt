package com.example.globoplay.feature.film.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.globoplay.databinding.ListMovieBinding
import com.example.globoplay.helper.loadImage
import com.example.globoplay.feature.film.data.model.Movie

class MovieAdapter(
    private val list: List<Movie>,
) : RecyclerView.Adapter<MovieAdapter.ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        return ViewHolderMovie(
            ListMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        val movies = list[position]
        with(holder.binding) {
            imgMovie.loadImage(movies.image)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolderMovie(val binding: ListMovieBinding) :
        RecyclerView.ViewHolder(binding.root)
}