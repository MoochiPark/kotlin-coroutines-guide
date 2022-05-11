package me.daewon.`01-coroutines-basics`

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWorld()
}

private suspend fun doWorld() = coroutineScope {
    val job = launch { // 새 코루틴을 실행하고 job에 대한 참조를 유지한다.
        delay(1000)
        println("World!")
    }
    println("Hello")
    job.join() // 하위 코루틴이 완료될 때까지 기다린다.
    println("Done")
}
