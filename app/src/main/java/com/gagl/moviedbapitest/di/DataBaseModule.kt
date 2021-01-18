package com.gagl.moviedbapitest.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.gagl.moviedbapitest.data.database.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataBaseModule {
    @Provides
    @Singleton
    fun provideMovieDataBase(@ApplicationContext context: Context) = databaseBuilder(context, MovieDataBase::class.java, "movieDbApiTest")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideMovieDao(movieDataBase: MovieDataBase) = movieDataBase.movieDao
}