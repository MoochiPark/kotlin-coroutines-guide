package me.daewon.`05-asyncronous-flow`

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import me.daewon.`04-coroutine-context-and-dispatchers`.log

fun simpleFlow4(): Flow<Int> = flow {
    log("Started simple flow")
    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking {
    simpleFlow4()
        .collect { value -> log("Collected $value") }
}
