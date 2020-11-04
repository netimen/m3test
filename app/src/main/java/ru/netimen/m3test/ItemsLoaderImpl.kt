package ru.netimen.m3test

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import ru.netimen.itemslib.data.GenericItem
import ru.netimen.itemslib.data.ItemsLoader
import ru.netimen.m3test.items.ItemsGenerator
import java.util.Date
import javax.inject.Inject

class ItemsLoaderImpl @Inject constructor(private val itemsGenerator: ItemsGenerator) : ItemsLoader {
    private val moshi by lazy {
        Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()
    }

    override fun loadItems(): List<GenericItem> {
        return generateSequence { itemsGenerator.item() }
            .map { item ->
                moshi.adapter(item.javaClass).toJsonValue(item).let { values ->
                    @Suppress("UNCHECKED_CAST") GenericItem(item.title, values as Map<String, Any>)
                }
            }
            .take((0..MAX_COUNT).random())
            .toList()
    }

    private companion object {
        private const val MAX_COUNT = 100
    }
}