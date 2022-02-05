package com.example.myapplication.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.myapplication.entity.Gorev
import com.example.myapplication.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var application: Application) {
    var yapilacaklar: MutableLiveData<List<Gorev>>
    var vt: AppDatabase

    init {
        yapilacaklar = MutableLiveData()
        vt = Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

    fun getAll(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklar.value = vt.userDao().getAll()
        }
    }
    fun add(gorev: Gorev){
        val job = CoroutineScope(Dispatchers.Main).launch {
            vt.userDao().insertAll(gorev)
        }
    }
    fun delete(gorev: Gorev){
        val job = CoroutineScope(Dispatchers.Main).launch {
            vt.userDao().delete(gorev)
            getAll()
        }
    }
    fun update(gorev: Gorev){
        val job = CoroutineScope(Dispatchers.Main).launch {
            vt.userDao().update(gorev)
        }
    }
}