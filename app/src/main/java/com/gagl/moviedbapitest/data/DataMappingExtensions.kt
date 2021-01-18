package com.gagl.moviedbapitest.data

import com.gagl.moviedbapitest.data.domain.Movie
import com.gagl.moviedbapitest.data.database.RoomMovie
import com.gagl.moviedbapitest.data.network.TMDBMovie

fun TMDBMovie.toDomain() = Movie(this.id, this.title, this.posterPath, this.backdropPath, this.overview, this.popularity)
fun RoomMovie.toDomain() = Movie(this.id, this.title, this.posterPath, this.backdropPath, this.overview, this.popularity)
fun Movie.toRoom() = RoomMovie(this.id, this.title, this.posterPath, this.backdropPath, this.overview, this.popularity)
