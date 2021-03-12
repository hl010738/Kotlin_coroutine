package coroutine

import kotlinx.coroutines.*

/*
    在协程的finally块中使用了挂起函数，会导致出现CancellationException异常，原因在于运行着该代码块的协程已经取消了。
    通常情况下，这并没有问题，因为大多数关闭操作（比如说取消一个job，关闭网络链接等）通常都是阻塞的，并不需要使用挂起函数；
    然而，在极少数情况下，当我们在一个取消的协程中进行挂起操作时，我们可以将相应的代码放置到withContext(NonCancellable)函数当中，在这种结构中，我们实际上使用了withContext函数与NonCancellable上下文.

 */

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(100) { a ->
                println("----------${a}")
                delay(500)
            }
        } finally {

            withContext(NonCancellable){
                println("finally")
                delay(1000)
                // 将这行代码放置在withContext内
                // 这行代码不会被执行
                println("delay后的代码")
            }

            /*
            println("finally")
            delay(1000)
            // 这行代码不会被执行
            println("delay后的代码")
             */

        }
    }

    delay(1300)
    println("=============")

    job.cancelAndJoin()
    println("+++++++++++")
}
