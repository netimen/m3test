package ru.netimen.itemslib.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.netimen.itemslib.R
import ru.netimen.itemslib.data.Item
import ru.netimen.itemslib.databinding.ItemsScreenBinding

@AndroidEntryPoint
class ItemsActivity : AppCompatActivity() {
    private lateinit var binding: ItemsScreenBinding
    private val viewModel: ItemsViewModel by viewModels()
    private val adapter = ItemsAdapter(this::onItemClicked)
    private val list get() = binding.list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        list.addItemDecoration(SpacingDecoration(resources.getDimensionPixelSize(R.dimen.margin_small)))

        viewModel.items.observe(this) { adapter.submitList(it) }
    }
    
    private fun onItemClicked(item: Item) {
        Toast.makeText(this, "item $item", Toast.LENGTH_SHORT).show()
    }
}

