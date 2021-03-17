package coroutine3

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

/*
    Job的使用方式以及在Context中的具体应用
    协程的job是归属其上下文（Context）的一部分，Kotlin提供了一种简洁的手段来通过协程上下文获取到协程自身的job对象
 */

fun main() = runBlocking {
    val job: Job? = coroutineContext[Job]
    println(job)
}
