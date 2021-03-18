package coroutine3

import kotlinx.coroutines.*


/*
    ThreadLocal
 */

val threadLocal = ThreadLocal<String>()

fun main() = runBlocking {
    threadLocal.set("aaaaaaaaa")
    println("pre main, current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")

    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "bbb")) {
        println("launch1, current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")
        yield()
        println("launch2, current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")
    }
    job.join()
    println("after main, current thread: ${Thread.currentThread()}, thread local value: ${threadLocal.get()}")
}
