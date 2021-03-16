package coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


/*
    关于父子协程的异常与取消的问题
    协程的取消总是会沿着协程层次体系向上传播
 */

fun main() = runBlocking {
    try {
        failureComputation()
    } finally {
        println("computation failed")
    }
}

private suspend fun failureComputation(): Int = coroutineScope {
    val value1 = async {
        try {
            delay(90000000)
            50
        } finally {
            println("value1 cancelled")
        }
    }

    val value2 = async<Int> {
        Thread.sleep(2000)
        println("throw exception")

        throw Exception()
    }

    value1.await() + value2.await()
}
