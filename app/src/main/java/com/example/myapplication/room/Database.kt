package com.example.myapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.entity.Gorev

@Database(entities = [Gorev::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): YapilacakDao
}