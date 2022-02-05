package com.example.myapplication.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.databinding.FragmentUpdateBinding
import com.example.myapplication.entity.Gorev
import com.example.myapplication.mvvm.VMF
import com.example.myapplication.mvvm.YapilacakViewModel

class update : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: YapilacakViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        val tempViewModel:YapilacakViewModel by viewModels(){
            VMF(requireActivity().application)
        }
        viewModel = tempViewModel
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val position = sharedPref!!.getInt("position", 0)

        binding.btnGuncelle.setOnClickListener{
            val id = viewModel.yapilacaklar.value!![position].id
            viewModel.guncelle(Gorev(id!!,binding.edTtextYapilacak.text.toString()))
            findNavController().popBackStack()
        }

        return binding.root
    }


}