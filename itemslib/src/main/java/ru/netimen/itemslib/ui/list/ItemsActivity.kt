package ru.netimen.itemslib.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.netimen.itemslib.data.GenericItem
import ru.netimen.itemslib.ui.item.ItemActivity
import ru.netimen.itemslib.ui.item.ItemViewModel
import ru.netimen.itemslib.ui.setupListContentView

@AndroidEntryPoint
class ItemsActivity : AppCompatActivity() {
    private val viewModel: ItemsViewModel by viewModels()
    private val adapter = ItemsAdapter(this::onItemClicked)
    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = setupListContentView(adapter, LinearLayoutManager(this))

        viewModel.items.observe(this) { adapter.submitList(it) }
    }
    
    private fun onItemClicked(item: GenericItem) {
        startActivity(Intent(this, ItemActivity::class.java)
            .apply { putExtra(ItemViewModel.ARG_ITEM, item) })
    }
}

