package com.gagl.moviedbapitest.data.network

import com.google.gson.annotations.SerializedName

data class TMDBMovie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title", alternate = ["name", "title"])
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double
)
