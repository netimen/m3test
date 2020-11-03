package ru.netimen.itemslib.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netimen.itemslib.R
import ru.netimen.itemslib.data.Item

internal class ItemsAdapter(private val itemClicked: (Item) -> Unit) : ListAdapter<Item, ItemViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(inflateView(parent.context))

    @SuppressLint("InflateParams")
    private fun inflateView(context: Context): TextView {
        return context.getSystemService<LayoutInflater>()?.inflate(R.layout.item, null) as TextView
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        getItem(position).let { item ->
            holder.view.text = item.shortDescription
            holder.view.setOnClickListener { itemClicked(item) }
        }
    }

    private companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem === newItem
            override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
        }
    }
}

internal class ItemViewHolder(val view: TextView) : RecyclerView.ViewHolder(view)
