package me.daewon.`04-coroutine-context-and-dispatchers`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    println("My job is ${coroutineContext[Job]}")
    launch {
        println("My job is ${coroutineContext[Job]}")
    }
    withContext(Dispatchers.Default) {
        println("My job is ${coroutineContext[Job]}")
    }
    coroutineScope {
        println("My job is ${coroutineContext[Job]}")
    }
    val a = async {
        println("My job is ${coroutineContext[Job]}")
    }
    a.await()
}
