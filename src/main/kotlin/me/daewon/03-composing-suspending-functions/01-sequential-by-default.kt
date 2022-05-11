package me.daewon.`03-composing-suspending-functions`

import kotlinx.coroutines.delay

suspend fun doSomethingUsefulOne(): Int {
    delay(1000)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000)
    return 29
}
