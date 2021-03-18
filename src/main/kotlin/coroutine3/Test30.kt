package coroutine3

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*

	* 对于父子协程来说，父协程总是会等待所有子协程的完成。对于父协程来说，它不必显式地去追踪由它所启动的所有子协程，同时也不必调用Job.join函数来等待协程的完成。
 */

fun main() = runBlocking {
    val request = launch {
        repeat(5) { a ->
            launch {
                delay((a + 1) * 100L)
                println("Coroutine $a finish")
            }
        }
        println("=============")
    }

    // join函数需要等待request执行完才往下执行
    request.join()
    println("--------------")
}
