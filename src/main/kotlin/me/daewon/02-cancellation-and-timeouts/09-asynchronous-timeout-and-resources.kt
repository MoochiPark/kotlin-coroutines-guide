package me.daewon.`02-cancellation-and-timeouts`

import kotlin.concurrent.thread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        repeat(1000) {
            thread {
                launch {
                    var resource: Resource? = null
                    try {
                        withTimeout(50) {
                            delay(50)
                            resource = Resource()
                        }
                    } finally {
                        resource?.close()
                    }
                }
            }
        }
    }
    println(acquired)
}
