package me.daewon.`04-coroutine-context-and-dispatchers`

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Activity {
//    private val mainScope = MainScope()
    private val mainScope = CoroutineScope(SupervisorJob())

    fun destroy() {
        mainScope.cancel()
    }

    fun doSomething() {
        repeat(10) { i ->
            mainScope.launch {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
    }
}

fun main(): Unit = runBlocking(SupervisorJob()) {
    val activity = Activity()
    activity.doSomething()
    println("Launched coroutines")
    delay(500)
    println("Destroying activity!")
    activity.destroy()
    delay(1000)
}
