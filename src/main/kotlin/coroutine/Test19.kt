package coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    挂起函数组合 - 并发执行挂起函数

		* 使用async与await实现并发执行挂起函数。从概念上来说，async就像是launch一样，它会开启一个单独的协程，这个协程就是一个轻量级线程，可以与其他协程并发工作。区别在于，launch会返回一个job，但是job并不会持有任何结果值，而async会返回一个Deferred，这是一个轻量级的非阻塞的future，它代表一个promise，可以在稍后提供一个结果值
		* 可以通过在一个deferred值上调用.await()函数来获取最终的结果值，Deferred也是个job，因此可以在需要时对其进行取消.
 */

fun main() = runBlocking {
    val elapsed = measureTimeMillis {

        // 并行等待执行完毕
        val value1 = async { intValue1() }
        val value2 = async { intValue2() }

        val result1 = value1.await()
        val result2 = value2.await()

        println("$result1 + $result2 = ${result1 + result2}")
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
