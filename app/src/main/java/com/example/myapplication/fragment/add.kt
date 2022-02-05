package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.YapilacakAdapter
import com.example.myapplication.databinding.FragmentAddBinding
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.entity.Gorev
import com.example.myapplication.mvvm.VMF
import com.example.myapplication.mvvm.YapilacakViewModel


class add : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: YapilacakViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        val tempViewModel: YapilacakViewModel by viewModels() {
            VMF(requireActivity().application)
        }
        viewModel = tempViewModel


        binding.btnKaydet.setOnClickListener{
            viewModel.ekle(Gorev(0,binding.edTtextYapilacak.text.toString()))
            findNavController().popBackStack()
        }
        return binding.root
    }


}