package com.igzafer.showsandmovies.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.igzafer.showsandmovies.R
import com.igzafer.showsandmovies.databinding.ActivityHomeBinding
import com.igzafer.showsandmovies.presentation.di.Injector
import com.igzafer.showsandmovies.presentation.view_model.MovieViewModel
import com.igzafer.showsandmovies.presentation.view_model.MovieViewModelFactory
import javax.inject.Inject


class HomeActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        (application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        initRecy()
    }

    private fun initRecy() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.updateMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()

            } else {
              Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }
            binding.progressBar.visibility = View.GONE
        })
    }
}