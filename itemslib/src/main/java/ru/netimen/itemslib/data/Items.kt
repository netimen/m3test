package ru.netimen.itemslib.data

typealias Items = List<Item>

data class Item(private val fields: Map<String, Any>) {
    val shortDescription = fields.toString()
}
