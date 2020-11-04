package ru.netimen.itemslib.data

import androidx.annotation.WorkerThread

@WorkerThread
interface ItemsLoader {
    fun loadItems(): List<GenericItem>
}