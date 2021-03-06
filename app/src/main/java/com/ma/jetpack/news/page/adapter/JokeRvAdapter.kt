package com.ma.jetpack.news.page.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ma.jetpack.news.data.entity.Joke
import com.ma.jetpack.news.databinding.ItemRvJokeBinding

class JokeRvAdapter() : PagedListAdapter<Joke, JokeRvAdapter.Holder>(
    diff
) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<Joke>() {
            override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    class Holder(val binding: ItemRvJokeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemRvJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.binding.joke = item
        holder.binding.executePendingBindings()
    }


}