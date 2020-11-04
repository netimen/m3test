package ru.netimen.itemslib.ui.item

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ru.netimen.itemslib.data.GenericItem

internal class ItemViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val item = savedStateHandle.get(ARG_ITEM) as GenericItem? ?: throw IllegalArgumentException("no item passed")
    val fields = liveData { emit(item.fields) }
    val title = liveData { emit(item.title) }

    companion object {
        const val ARG_ITEM = "fields"
    }
}
