package me.daewon.`05-asyncronous-flow`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun simpleFlow5(): Flow<Int> = flow {
    withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(100) // CPU consuming
            emit(i)
        }
    }
}

fun main() = runBlocking {
    simpleFlow5()
        .collect(::println)
}
