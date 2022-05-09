package me.daewon.`coroutines-basics`

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWorld()
    println("Done")
}

private suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000)
        println("World2")
    }
    launch {
        delay(1000)
        println("World1")
    }
    println("Hello")
}
