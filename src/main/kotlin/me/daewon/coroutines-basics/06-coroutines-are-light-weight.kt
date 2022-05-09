package me.daewon.`coroutines-basics`

import kotlin.concurrent.thread
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    repeat(100_000) {
        launch {
            delay(5000)
            println(".")
        }
    }
}

//fun main() {
//    repeat(100_000) {
//        thread {
//            Thread.sleep(5000)
//            println(".")
//        }
//    }
//}

