package coroutine2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Dispatchers.Unconfined
 */

fun main() = runBlocking {
    launch(Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined, thread: ${Thread.currentThread().name}")
        delay(300)
        println("Dispatchers.Unconfined, thread: ${Thread.currentThread().name}")
    }
    launch {
        println("No param, thread: ${Thread.currentThread().name}")
        delay(300)
        println("No param, thread: ${Thread.currentThread().name}")
    }

    println("-------------")
}
