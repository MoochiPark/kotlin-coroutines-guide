package me.daewon.`coroutines-basics`

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    launch { // 새로운 코루틴을 launch하고 계속한다.
        delay(1000) // 논블로킹의 지연을 1초간 수행한다.
        println("World!") // 지연 후의 출력
    }
    println("Hello") // 이전 코루틴이 지연되는 동안 메인 코루틴이 계속된다.
}
