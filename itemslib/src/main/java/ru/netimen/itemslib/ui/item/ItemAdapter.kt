package ru.netimen.itemslib.ui.item

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.netimen.itemslib.R
import ru.netimen.itemslib.data.Field
import ru.netimen.itemslib.ui.list.ItemViewHolder

internal class ItemAdapter : ListAdapter<Field, ItemViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(inflateView(parent.context))

    @SuppressLint("InflateParams")
    private fun inflateView(context: Context): TextView {
        return context.getSystemService<LayoutInflater>()?.inflate(R.layout.field, null) as TextView
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        getItem(position / 2).let { item ->
            holder.view.text = if ((position and 1) == 1) item.value.toString() else "${item.key}:"
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() * 2
    }

    private companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Field>() {
            override fun areItemsTheSame(oldItem: Field, newItem: Field) = oldItem === newItem
            override fun areContentsTheSame(oldItem: Field, newItem: Field) = oldItem == newItem
        }
    }
}
