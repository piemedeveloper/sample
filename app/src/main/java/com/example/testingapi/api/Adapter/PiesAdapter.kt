package com.example.testingapi.api.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.testingapi.ComposeActivity
import com.example.testingapi.MainActivity
import com.example.testingapi.api.data.DataMan
import com.example.testingapi.api.data.DataX
import com.example.testingapi.api.data.response.Data
import com.example.testingapi.databinding.AdapterDataBinding
import com.example.testingapi.databinding.ItemPostBinding

class PiesAdapter: RecyclerView.Adapter<PiesAdapter.MainViewHolder>() {
    class MainViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    var data = mutableListOf<Data>()
    var images = mutableListOf<String>()
    fun setDataList(data: List<Data>) {
        this.data = data.toMutableList()

        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val data = data[position]
        holder.binding.tvPostAuthor.text = data.user_name
        val piemates= data.likes
        holder.binding.tvPostText.text = "$piemates Likes "
        Glide.with(holder.itemView.context)
            .load(data.profile_pic)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(holder.binding.ivAuthorProfileImage)

        //images = data.pies_media_url as MutableList<String>
         Glide.with(holder.itemView.context)

            .load(data.pies_media_url?.get(0))
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(holder.binding.ivPostImage)

        holder.binding.ibDeletePost.setOnClickListener {
            val context=holder.binding.ibDeletePost.context
            val intent = Intent( context, ComposeActivity::class.java)
            context.startActivity(intent)

        }
    }
    override fun getItemCount(): Int {
        return data.size
    }
}
