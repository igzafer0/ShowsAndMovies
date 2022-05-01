package com.igzafer.showsandmovies.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.igzafer.showsandmovies.R
import com.igzafer.showsandmovies.databinding.ActivityHomeBinding
import com.igzafer.showsandmovies.presentation.di.Injector
import com.igzafer.showsandmovies.presentation.view_model.MovieViewModel
import com.igzafer.showsandmovies.presentation.view_model.MovieViewModelFactory
import javax.inject.Inject


class HomeActivity : AppCompatActivity() {
    @Inject
    lateinit var factory:MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        (application as Injector).createMovieSubComponent().inject(this)
        viewModel=ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        val responseLiveData=viewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("winter",it.toString())
        })
    }
}