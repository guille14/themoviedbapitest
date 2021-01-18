package com.gagl.moviedbapitest.data.database

import com.gagl.moviedbapitest.data.domain.LocalDataSource
import com.gagl.moviedbapitest.data.domain.Movie
import com.gagl.moviedbapitest.data.toDomain
import com.gagl.moviedbapitest.data.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomMovieDataSource @Inject constructor(private val movieDao: MovieDao): LocalDataSource {
    override suspend fun size(): Int = movieDao.count()
    override suspend fun saveMovies(movies: List<Movie>) = movieDao.insertMovies(movies.map{it.toRoom()})
    override fun getTopRatedMovies(): Flow<List<Movie>> = movieDao.getTopRatedMovies().map { moviesList -> moviesList.map { it.toDomain() } }
}