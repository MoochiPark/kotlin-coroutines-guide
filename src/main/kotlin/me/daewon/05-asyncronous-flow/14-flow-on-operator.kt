package me.daewon.`05-asyncronous-flow`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import me.daewon.`04-coroutine-context-and-dispatchers`.log

fun simpleFlow6(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100)
        log("Emitting $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    simpleFlow6().collect { value ->
        log("Collected $value")
    }
}
