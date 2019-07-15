package coroutine

import kotlinx.coroutines.*

/*
    协程嵌套
 */
fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin coroutine")
    }

    println("------")

    delay(2000)

    println("========")
}