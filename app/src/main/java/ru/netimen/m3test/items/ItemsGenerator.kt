package ru.netimen.m3test.items

import java.util.Date
import java.util.UUID
import javax.inject.Inject
import kotlin.random.Random

class ItemsGenerator @Inject constructor() {
    fun item() = factory[factory.indices.random()].invoke()

    companion object Factory {
        val factory = listOf( // you will need to add a factory here, when adding new item type
            { Notice(randomDate(), randomString()) },
            { Move(randomString(), randomString(), Random.nextDouble()) },
            { Event(randomString(), randomDate(), randomDate()) }
        )

        private fun randomString() = UUID.randomUUID().toString()
        private fun randomDate() = Date(System.currentTimeMillis() + Random.nextInt())
    }
}