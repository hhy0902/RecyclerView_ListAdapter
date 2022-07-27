package com.example.recyclerview_listadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview_listadapter.model.Item

class TestAdapter : ListAdapter<Item, TestAdapter.ViewHolder>(differ) {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : Item) {
            val imageView = itemView.findViewById<ImageView>(R.id.ImageView)
            val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
            val priceTextView = itemView.findViewById<TextView>(R.id.priceTextView)

            titleTextView.text = item.title
            priceTextView.text = item.price

            Glide.with(imageView.context)
                .load(item.imageUrl)
                .into(imageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: TestAdapter.ViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }

    companion object {
        val differ = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }

}












































