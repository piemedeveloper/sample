package com.example.testingapi.api.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.testingapi.api.data.DataMan
import com.example.testingapi.api.data.DataX
import com.example.testingapi.databinding.AdapterDataBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: AdapterDataBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    var data = mutableListOf<DataX>()
    fun setDataList(data: List<DataX>) {
        this.data = data.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterDataBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = data[position]
        holder.binding.textName.text = data.user_id
        holder.binding.textCount.text = data.last_name
        Glide.with(holder.itemView.context)
            .load(data.profile_pic)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(holder.binding.img)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}
