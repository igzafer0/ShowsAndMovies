package com.igzafer.showsandmovies.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.igzafer.showsandmovies.data.db.MovieDAO

import com.igzafer.showsandmovies.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java,"showsandmovies").build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDAO{
        return tmdbDatabase.movieDao()
    }

}