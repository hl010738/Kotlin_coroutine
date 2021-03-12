package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/*
    在使用协程时，如果取消了协程，那么很大一部分原因都是因为执行时间超过了某个设定值；
    可以通过手工引用与协程对应的Job的方式来启动一个单独的协程用于取消这个协程，
    不过Kotlin提供了一个内置的函数来实现。
 */

fun main() = runBlocking {
    withTimeout(1900) {
        repeat(1000) { a->
            println("--------------${a}")
            delay(400)
        }
    }
}
