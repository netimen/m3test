package ru.netimen.itemslib.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.netimen.itemslib.data.Items
import ru.netimen.itemslib.data.Repository

internal class ItemsViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {
    val items: LiveData<Items> get() = itemsData
    private val itemsData = MutableLiveData<Items>()

    init {
        viewModelScope.launch { itemsData.value = repository.getItems() }
    }
}