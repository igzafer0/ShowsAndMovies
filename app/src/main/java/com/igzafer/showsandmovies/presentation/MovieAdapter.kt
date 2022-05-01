package com.igzafer.showsandmovies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.igzafer.showsandmovies.R
import com.igzafer.showsandmovies.data.model.Movie
import com.igzafer.showsandmovies.databinding.MoviesRowBinding

class MovieAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val movieList = ArrayList<Movie>()
    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MoviesRowBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.movies_row, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MyViewHolder(val binding: MoviesRowBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.titleTw.text = movie.title
        binding.descTw.text = movie.overview
        val posterPath = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.posterIm.context).load(posterPath).into(binding.posterIm)

    }
}