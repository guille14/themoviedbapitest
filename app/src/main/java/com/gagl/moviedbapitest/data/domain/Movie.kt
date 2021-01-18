package com.gagl.moviedbapitest.data.domain

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val backdropPath: String?,
    val overview: String,
    val popularity: Double
)
