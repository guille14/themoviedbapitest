package com.gagl.moviedbapitest.data.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withTimeout
import javax.inject.Inject

class MoviesRepository @Inject constructor(val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) {
    fun getTopRatedMovies() = localDataSource.getTopRatedMovies()

    suspend fun checkTopRatedNewPageRequired(lastVisibleItem: Int) {
        val size = localDataSource.size()

        if(lastVisibleItem >= size - 20) {
            val page = size / 20 + 1
            val newMoviesResource = withTimeout(5_000) { remoteDataSource.getTopRatedMovies(page) }
            if(newMoviesResource.status == Status.SUCCESS)
                localDataSource.saveMovies(newMoviesResource.data!!)
        }
    }
}

interface RemoteDataSource {
    suspend fun getTopRatedMovies(page: Int): Resource<List<Movie>>
}

interface LocalDataSource {
    suspend fun size(): Int
    suspend fun saveMovies(movies: List<Movie>)
    fun getTopRatedMovies(): Flow<List<Movie>>
}