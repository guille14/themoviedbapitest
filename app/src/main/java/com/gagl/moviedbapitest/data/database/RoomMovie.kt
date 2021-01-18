package com.gagl.moviedbapitest.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
data class RoomMovie(
    @PrimaryKey
    val id: Int,
    val title: String,
    val posterPath: String,
    val backdropPath: String?,
    val overview: String,
    val popularity: Double
    )
