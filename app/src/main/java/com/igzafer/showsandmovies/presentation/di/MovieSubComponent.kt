package com.igzafer.showsandmovies.presentation.di

import com.igzafer.showsandmovies.presentation.HomeActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(homeActivity: HomeActivity) {}

    @Subcomponent.Factory
    interface factory{
        fun create():MovieSubComponent
    }
}