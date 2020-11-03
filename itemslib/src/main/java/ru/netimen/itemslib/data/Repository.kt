package ru.netimen.itemslib.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class Repository @Inject constructor(private val loader: ItemsLoader) {
    suspend fun getItems() = withContext(Dispatchers.Default) { loader.loadItems() }
}