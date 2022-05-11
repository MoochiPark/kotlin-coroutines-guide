package me.daewon.`03-composing-suspending-functions`

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

@OptIn(DelicateCoroutinesApi::class)
fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}

fun main() {
    val time = measureTimeMillis {
        // 비동기 동작을 코루틴 밖에서 초기화할 수 있다.
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        // 하지만 결과를 기다리는 것은 일시 중단 혹은 치단(blocking)이어야 한다.
        // 여기서는 runBlocking을 사용하여 결과를 기다리는 동안 메인 스레드를 차단한다.
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}
