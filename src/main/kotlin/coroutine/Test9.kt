package coroutine

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/*
    协程和线程对比
 */

fun main() = runBlocking{
    // 无法创建10000个线程，但是协程可以
    repeat(10000){
        thread {
            Thread.sleep(1000)
            println("A")
        }
    }
    println("-------------")
}