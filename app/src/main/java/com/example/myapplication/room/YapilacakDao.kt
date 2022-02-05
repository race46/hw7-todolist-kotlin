package com.example.myapplication.room

import androidx.room.*
import com.example.myapplication.entity.Gorev

@Dao
interface YapilacakDao {
    @Query("SELECT * FROM gorev")
    suspend fun getAll(): List<Gorev>

    @Insert
    suspend fun insertAll(vararg gorev: Gorev)

    @Delete
    suspend fun delete(gorev: Gorev)

    @Update
    suspend fun update(gorev: Gorev)
}