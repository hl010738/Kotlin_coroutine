package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    使用协程一次性返回集合
    不会阻塞主线程
 */

fun main() = runBlocking {
    func1().forEach { println(it) }
}

private suspend fun func1(): List<String> {
    delay(1000)
    return listOf("aaa", "bbb", "ccc", "ddd")
}
