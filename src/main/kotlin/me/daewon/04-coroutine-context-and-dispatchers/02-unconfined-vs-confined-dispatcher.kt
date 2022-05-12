package me.daewon.`04-coroutine-context-and-dispatchers`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(Dispatchers.Unconfined) {
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        delay(500)
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
    }

    launch {
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        delay(1000)
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }
}
