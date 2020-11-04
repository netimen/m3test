package ru.netimen.itemslib.ui.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ru.netimen.itemslib.data.Repository

internal class ItemsViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {
    val items = liveData { emit(repository.getItems()) }
}