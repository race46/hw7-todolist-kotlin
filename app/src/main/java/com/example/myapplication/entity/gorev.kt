package com.example.myapplication.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gorev(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var yapilacak:String
)