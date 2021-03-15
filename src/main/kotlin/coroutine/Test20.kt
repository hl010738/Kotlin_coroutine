package coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    关于async的延迟执行

    可以他哦那个过将async方法的start参数设置为CoroutineStart.LAZY来实现协程的延迟执行。
    这种情况下，协程会在两种场景下去执行：调用Deferred的await方法，或是调用Job的start方法.
 */

fun main() = runBlocking {
    val elapsed = measureTimeMillis {

        // 使用lazy，async不会马上执行
        // 而是等待到start才开始执行
        val value1 = async(start = CoroutineStart.LAZY) { intValue1() }
        val value2 = async(start = CoroutineStart.LAZY) { intValue2() }

        println("==============")

        Thread.sleep(6000)

        value1.start()
        value2.start()

        println("------------")

        val result2 = value2.await()
        val result1 = value1.await()


        println("$result1 + $result2 = ${result1 + result2}")
    }

    println("total time: $elapsed")
}

private suspend fun intValue1(): Int{
    println("value1")
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int{
    println("value2")
    delay(3000)
    return 20
}
