package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
    Kotlin coroutine 协程
    协程与线程的对比
 */

fun main() {
    GlobalScope.launch {
        println("Kotlin")
        delay(1000)
        println("coroutine")
    }

    println("-----------")

    Thread.sleep(1000) //当前线程晚于协程退出，协程会执行
    //Thread.sleep(500) 当前线程早于协程退出，协程会执行一部分
    //                  当线程退出后，协程剩余的部分不会执行.

    println("==============")
}