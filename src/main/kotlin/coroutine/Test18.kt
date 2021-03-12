package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    挂起函数组合 - 串行执行挂起函数
 */

fun main() = runBlocking {
    val elapsed = measureTimeMillis {
        val value1 = intValue1()
        val value2 = intValue2()

        println("$value1 + $value2 = ${value1 + value2}")
    }

    println("total time: $elapsed")
}

private suspend fun intValue1(): Int{
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int{
    delay(3000)
    return 20
}
