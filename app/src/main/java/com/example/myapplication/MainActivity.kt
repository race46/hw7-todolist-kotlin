package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.entity.Gorev
import com.example.myapplication.mvvm.VMF
import com.example.myapplication.mvvm.YapilacakViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:YapilacakViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tempViewModel:YapilacakViewModel by viewModels(){
            VMF(this.application)
        }
        viewModel = tempViewModel

    }
}