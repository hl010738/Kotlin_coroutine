package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    每一个协程构建器（包括launch和runBlocking）都会向其代码块作用域中添加一个CoroutineScope实例.
    我们可以在该作用域中启动协程，而无需显式的join到一起，这是因为外部协程会等待内部所有协程执行完成之后才会结束.

 */
fun main() = runBlocking{

    // 如果没有GlobalScope，那么系统会等待协程完成
    // 如果是GlobalScope.launch，系统不会等待协程完成
    launch {
        delay(1000)
        println("Kotlin coroutine")
    }

    println("---------")
}