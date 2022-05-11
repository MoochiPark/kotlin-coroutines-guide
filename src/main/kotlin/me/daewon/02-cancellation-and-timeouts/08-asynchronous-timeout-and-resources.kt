package me.daewon.`02-cancellation-and-timeouts`

import kotlin.concurrent.thread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

var acquired = 0

class Resource {
    init {
        acquired++
    } // 리소스 획득

    fun close() {
        acquired--
    } // 리소스 해제
}

fun main() {
    runBlocking {
        repeat(1000) {
            thread {
                launch {
                    val resource = withTimeout(50) {
                        delay(50)
                        Resource()
                    }
                    resource.close()
                }
            }
        }
    }
    println(acquired)
}
