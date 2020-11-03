package ru.netimen.m3test.items

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
class Notice(val flightDate: Date? = null, val gate: String? = null)

@JsonClass(generateAdapter = true)
class Event(val name: String? = null, val startTime: Date? = null, val endTime: Date? = null)

@JsonClass(generateAdapter = true)
class Move(val fromPlace: String? = null, val toPlace: String? = null, val estimateTime: Double? = null)

// Don't forget to register a factory in ItemsGenerator
