package me.daewon.`05-asyncronous-flow`

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun simpleSuspending(): List<Int> {
    delay(1000)
    return listOf(1, 2, 3)
}

fun main() = runBlocking {
    simpleSuspending().forEach { value ->
        println(value)
    }
}
