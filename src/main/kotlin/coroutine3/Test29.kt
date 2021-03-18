package coroutine3

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*

	* 关于父子协程之间的关系
		* 当一个协程是通过另外一个协程的coroutineScope来启动的，那么这个协程就会通过CoroutineScope.coroutineContext来继承其上下文信息。同时，新协程的Job就会成父协程的一个子协程；当父协程被取消执行时，该父协程的所有子协程都会通过递归的方式一并取消执行。
		* 特例情况：使用GlobalScope来启动 协程时，对于启动的新协程来说，其Job时没有父Job的。因此，他就不会绑定到其所启动的那个范围上，故其可以独立自行。
 */

fun main() = runBlocking {
    val request = launch {
        GlobalScope.launch {
            println("===========")
            delay(1000)
            println("-------------")
        }
        launch {
            delay(100)
            println("++++++++++++")
            delay(1000)
            println("***********")
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("aaaaaaaaaaa")
}
