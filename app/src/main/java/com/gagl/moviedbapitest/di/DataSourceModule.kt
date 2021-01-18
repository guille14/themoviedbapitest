package com.gagl.moviedbapitest.di

import com.gagl.moviedbapitest.data.domain.LocalDataSource
import com.gagl.moviedbapitest.data.domain.RemoteDataSource
import com.gagl.moviedbapitest.data.database.RoomMovieDataSource
import com.gagl.moviedbapitest.data.network.TheMovieDBApiDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindLocalDataSource(roomMovieDataSource: RoomMovieDataSource): LocalDataSource
    @Binds
    abstract fun bindRemoteDataSource(theMovieDBApiDataSource: TheMovieDBApiDataSource): RemoteDataSource
}