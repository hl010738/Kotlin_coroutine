package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    val job = GlobalScope.launch {
        delay(1000)
        println("Kotlin coroutine")
    }

    println("---------------")

    job.join()  // join方法会挂起当前线程等待Job完成之后继续执行

    println("================")
}