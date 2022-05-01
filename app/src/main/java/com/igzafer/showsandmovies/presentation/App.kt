package com.igzafer.showsandmovies.presentation

import android.app.Application
import com.igzafer.showsandmovies.BuildConfig
import com.igzafer.showsandmovies.presentation.di.Injector
import com.igzafer.showsandmovies.presentation.di.MovieSubComponent
import com.igzafer.showsandmovies.presentation.di.core.*
import dagger.android.DaggerApplication

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY, BuildConfig.LANGUAGE)).build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}