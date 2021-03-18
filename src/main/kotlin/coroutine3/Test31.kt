package coroutine3

import kotlinx.coroutines.*


/*
    CoroutineName上下文元素可以对协程进行命名。
 */

fun main() = runBlocking(CoroutineName("main")) {
    log("+++++++++")

    val a = async(CoroutineName("coroutine1")) {
        delay(800)
        log("--------------")
        30
    }

    val b = async(Dispatchers.Default + CoroutineName("coroutine2")) {
        delay(100)
        log("=============")
        30
    }

    log("The result is ${a.await() * b.await()}")
}

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")
