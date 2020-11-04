package ru.netimen.itemslib.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.netimen.itemslib.R
import ru.netimen.itemslib.databinding.ScreenListBinding

fun AppCompatActivity.setupListContentView(adapter: RecyclerView.Adapter<*>, layoutManager: RecyclerView.LayoutManager): RecyclerView {
    val binding = ScreenListBinding.inflate(layoutInflater)
    setContentView(binding.root)
    return binding.list.also {
        it.layoutManager = layoutManager
        it.adapter = adapter
        it.addItemDecoration(SpacingDecoration(resources.getDimensionPixelSize(R.dimen.margin_small)))
    }
}
