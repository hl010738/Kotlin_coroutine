package coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


/*
    异步风格的函数
*/

fun main(){
    val elapsed = measureTimeMillis {

        val value1 = intValue1Async()

        val value2 = intValue2Async()

        // runBlocking会阻塞线程等待value1和value2执行完成
        runBlocking {
            println("++++++++++: ${value1.await() + value2.await()}")
        }

    }

    println("total time: $elapsed")
}

fun intValue1Async() = GlobalScope.async {
    intValue1()
}

fun intValue2Async() = GlobalScope.async {
    intValue2()
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
