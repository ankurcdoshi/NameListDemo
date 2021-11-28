package com.plantix.namelistdemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.plantix.namelistdemo.databinding.RowNameBinding

class NameListAdapter(private val nameList: List<String>):
        RecyclerView.Adapter<NameListAdapter.NameViewHolder>() {

    inner class NameViewHolder(private val itemBinding: RowNameBinding):
            RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: String) {
            itemBinding.name = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        return NameViewHolder(RowNameBinding.inflate(LayoutInflater.from(parent.context), parent,
            false))
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(nameList[position])
    }

    override fun getItemCount() = nameList.size
}