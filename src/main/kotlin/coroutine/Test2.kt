package coroutine

import kotlin.concurrent.thread

/*
    协程与线程的对比

    两个线程启动后相互独立执行
 */
fun main() {
    thread {
        Thread.sleep(1000)
        println("Kotlin coroutine")
    }

    println("-----------")

    Thread.sleep(100)

    println("==============")
}