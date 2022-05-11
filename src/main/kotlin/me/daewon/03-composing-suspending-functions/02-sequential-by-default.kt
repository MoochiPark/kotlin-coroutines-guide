package me.daewon.`03-composing-suspending-functions`

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
}
