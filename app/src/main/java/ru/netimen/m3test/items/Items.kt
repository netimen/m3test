package ru.netimen.m3test.items

import com.squareup.moshi.JsonClass
import ru.netimen.itemslib.data.Item
import java.util.Date

@JsonClass(generateAdapter = true)
class Notice(val flightDate: Date? = null, val gate: String? = null) : Item {
    override val title get() = "Notice $flightDate"
}

@JsonClass(generateAdapter = true)
class Event(val name: String? = null, val startTime: Date? = null, val endTime: Date? = null) : Item {
    override val title get() = "Event $name"
}

@JsonClass(generateAdapter = true)
class Move(val fromPlace: String? = null, val toPlace: String? = null, val estimateTime: Double? = null) : Item {
    override val title get() = "Move $toPlace"
}

// Don't forget to register a factory in ItemsGenerator for new types
