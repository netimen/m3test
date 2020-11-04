package ru.netimen.itemslib.data

import java.io.Serializable

interface Item {
    val title: String
}

typealias Field = Map.Entry<String, Any>
typealias Fields = Map<String, Any>

data class GenericItem(override val title: String, val fields: Fields) : Item, Serializable
