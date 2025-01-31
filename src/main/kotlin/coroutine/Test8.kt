package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    协程是轻量级的 与 线程对比
 */

fun main() = runBlocking{
    repeat(10000){
        launch {
            delay(1000)
            println("A")
        }
    }
    println("----------")
}