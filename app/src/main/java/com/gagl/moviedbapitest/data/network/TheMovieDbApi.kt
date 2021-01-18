package com.gagl.moviedbapitest.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApi {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int): Response<MovieDBResult<TMDBMovie>>
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieDBResult<TMDBMovie>>

    @GET("search/movie")
    suspend fun searchMovies(): Response<MovieDBResult<TMDBMovie>>
}