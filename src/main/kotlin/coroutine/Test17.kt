package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


/*

	* 由withTimeout函数调用所抛出的TimeoutCancellationException异常是CancellationException的子类。当该异常抛出时，并不会在控制台上看到整个异常堆栈信息，这是因为在取消的协程当中，CancellationException被认为时一种协程完成的正常原因。
	* 既然CancellationException只是一个异常，所有资源也都会以通常的方式来关闭，那么就可以将相关代码放到一个try...catch块中；此外，Kotlin还提供了另外一个更加友好的函数调用：withTimeoutOrNull；从功能角度来看，它非常类似与withTimeout，不过当超时发生时，它并不会抛出CancellationException异常，而是会直接返回null。

 */

fun main() = runBlocking {
    val result = withTimeoutOrNull(1900) {
        repeat(1000) {a ->
            println("-----------$a")
            delay(300)
        }

        "result"
    }

    println("result = $result")
}
