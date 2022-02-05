package com.example.myapplication.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.RecItemBinding
import com.example.myapplication.entity.Gorev
import com.example.myapplication.mvvm.YapilacakViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacakAdapter(private val gorevler: List<Gorev>,var viewModel: YapilacakViewModel,val activity:Activity) :
    RecyclerView.Adapter<YapilacakAdapter.AdapterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AdapterHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rec_item, parent, false ))
    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        if(position == gorevler.size)
            holder.binding.cardView.visibility = View.INVISIBLE
        else {
            holder.binding.grv = gorevler[position]
            holder.binding.imageView.setOnClickListener {
                val sb = Snackbar.make(
                    it,
                    gorevler[position].yapilacak + " silinsin mi?",
                    Snackbar.LENGTH_LONG
                )
                sb.setAction("Sil") {
                    viewModel.sil(gorevler[position])
                    viewModel.refresh()
                }
                sb.show()
            }

            holder.binding.cardView.setOnClickListener{
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return@setOnClickListener
                with (sharedPref.edit()) {
                    putInt("position", position)
                    apply()
                }
                Navigation.findNavController(it).navigate(R.id.action_main_to_update)
            }
        }

    }
    override fun getItemCount() = gorevler.size + 1
    class AdapterHolder(val binding: RecItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}