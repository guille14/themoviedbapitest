package com.gagl.moviedbapitest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        RoomMovie::class
               ],
    version = 1,
    exportSchema = false
)
abstract class MovieDataBase: RoomDatabase() {
    abstract val movieDao: MovieDao
}
