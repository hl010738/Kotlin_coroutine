import kotlinx.coroutines.*

/*
    协程取消与超时
 */

fun main() = runBlocking {

    val job1 = GlobalScope.launch {
        repeat(200) {
            i -> println("---$i")
            delay(500)
        }
    }

    delay(1100)
    println("==============")

    // 协程取消并合并到主流程
    job1.cancelAndJoin()
    //job1.cancel()
    //job1.join()

    println("**********")
}
