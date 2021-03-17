package coroutine2

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/*
    使用VM参数：-Dkotlinx.coroutines.debug
    可以将协程的信息打印出来
 */

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking<Unit> {
    val a = async {
        log("============")
        10
    }

    val b = async {
        log("----------------")
        20
    }

    log("The result is ${a.await() * b.await()}")
}
