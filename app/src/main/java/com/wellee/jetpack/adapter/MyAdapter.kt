package com.wellee.jetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ToastUtils
import com.wellee.jetpack.databinding.ItemRvMainBinding
import com.wellee.jetpack.db.User

class MyAdapter(diff: DiffUtil.ItemCallback<User>) :PagedListAdapter<User, MyAdapter.MyViewHolder>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRvMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MyViewHolder(private val binding: ItemRvMainBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: User?) {
            binding.bean = item
            binding.listener = View.OnClickListener {
                ToastUtils.showShort("点击了 item $item")
            }
        }
    }
}