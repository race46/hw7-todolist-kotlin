package com.example.myapplication.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.myapplication.entity.Gorev
import com.example.myapplication.repo.YapilacaklarDaoRepository
import com.example.myapplication.room.AppDatabase

class YapilacakViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = YapilacaklarDaoRepository(application)
    val dao = repo.vt.userDao()
    val yapilacaklar = repo.yapilacaklar
    var cur = MutableLiveData<Int>()

    init {
        refresh()
    }

    fun ekle(gorev: Gorev){
        repo.add(gorev)
    }
    fun sil(gorev: Gorev){
        repo.delete(gorev)
        refresh()
    }
    fun refresh(){
        repo.getAll()
    }
    fun guncelle(gorev: Gorev){
        repo.update(gorev)
    }


}