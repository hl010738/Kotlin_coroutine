package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
    Kotlin coroutine 协程
 */

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin coroutine")
    }

    println("-----------")

    Thread.sleep(2000)

    println("==============")
}