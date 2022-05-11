package me.daewon.`03-composing-suspending-functions`

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }

        one.start()
        two.start()

        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}
