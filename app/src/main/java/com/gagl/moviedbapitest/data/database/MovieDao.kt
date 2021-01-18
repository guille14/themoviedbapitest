package com.gagl.moviedbapitest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(movie: List<RoomMovie>)

    @Query("SELECT count(id) FROM Movie")
    suspend fun count(): Int

    @Query("SELECT * FROM Movie")
    fun getTopRatedMovies(): Flow<List<RoomMovie>>
}