package com.gagl.moviedbapitest.di

import com.gagl.moviedbapitest.data.domain.LocalDataSource
import com.gagl.moviedbapitest.data.domain.MoviesRepository
import com.gagl.moviedbapitest.data.domain.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoriesModule {
    @Provides
    @Singleton
    fun provideMoviesRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource) = MoviesRepository(localDataSource, remoteDataSource)
}