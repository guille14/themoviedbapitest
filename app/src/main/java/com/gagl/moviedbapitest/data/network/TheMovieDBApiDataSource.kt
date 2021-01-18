package com.gagl.moviedbapitest.data.network

import com.gagl.moviedbapitest.data.domain.Movie
import com.gagl.moviedbapitest.data.domain.RemoteDataSource
import com.gagl.moviedbapitest.data.domain.Resource
import com.gagl.moviedbapitest.data.domain.Status
import com.gagl.moviedbapitest.data.toDomain
import javax.inject.Inject

class TheMovieDBApiDataSource @Inject constructor(private val tmdbApi: TheMovieDbApi): RemoteDataSource {
    override suspend fun getTopRatedMovies(page: Int): Resource<List<Movie>> {
            val resource = handleApi({
                tmdbApi.getTopRatedMovies(page)
            })

        return when(resource.status){
            Status.SUCCESS -> {
                val pagedResponse = resource.data!!
                Resource.success(pagedResponse.results.map { it.toDomain() })
            }
            Status.ERROR -> Resource.error(resource.message)
        }
    }

}