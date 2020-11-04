package ru.netimen.itemslib.ui.item

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.netimen.itemslib.ui.setupListContentView

@AndroidEntryPoint
class ItemActivity : AppCompatActivity() {
    private val viewModel: ItemViewModel by viewModels()
    private val adapter = ItemAdapter()
    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = setupListContentView(adapter, GridLayoutManager(this, 2))

        viewModel.fields.observe(this) { adapter.submitList(it.entries.toList()) }
        viewModel.title.observe(this) { title = it }
    }
}
