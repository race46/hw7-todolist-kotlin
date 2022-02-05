package com.example.myapplication.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.adapter.YapilacakAdapter
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.entity.Gorev
import com.example.myapplication.mvvm.VMF
import com.example.myapplication.mvvm.YapilacakViewModel
import kotlinx.coroutines.runBlocking

class main : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: YapilacakViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        val tempViewModel:YapilacakViewModel by viewModels(){
            VMF(requireActivity().application)
        }
        viewModel = tempViewModel
        viewModel.yapilacaklar.observe(viewLifecycleOwner) {
            binding.recyclerView.adapter = YapilacakAdapter(it,viewModel,requireActivity())
        }
        binding.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_main_to_add2)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()

    }

}