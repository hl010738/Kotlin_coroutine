package coroutine

import kotlinx.coroutines.*



/*
    run blocking 函数
 */

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin coroutine")
    }

    println("-------------")

    runBlocking {
        delay(2000)
    }

    println("=============")
}