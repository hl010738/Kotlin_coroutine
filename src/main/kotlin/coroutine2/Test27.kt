package coroutine2

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() {
    println("--------")
    newSingleThreadContext("a").use { a ->
        newSingleThreadContext("b").use { b ->
            runBlocking(a) {
                log("aaaaaaaaaaaaaaaa")

                //显式切换上下文
                withContext(b){
                    log("bbbbbbbbbbbbbbbb")
                }

                log("=========aaaaaaaaa")
            }
        }
    }
}

