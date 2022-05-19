package me.daewon.`05-asyncronous-flow`

fun simpleSequence(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100)
        yield(i)
    }
}

fun main() {
    simpleSequence().forEach { value ->
        println(value)
    }
}
