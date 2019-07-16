package coroutine


import kotlinx.coroutines.*

/*
    除去不同的协程构建器所提供的协程作用域（coroutine scope）外，还可以通过coroutine scope builder来声明自己的协程作用域.
    builder会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成.

    runBlocking和coroutineScope之间的区别在于，后者在等待所有子协程完成任务时并不会阻塞当前线程.
 */

fun main() = runBlocking{
    launch {
        delay(1000)
        println("launch")
    }
    println("------------")

    coroutineScope{
        launch {
            delay(5000)
            println("coroutine scope")
        }
        delay(3000)
        println("=============")
    }

    println("***************")
}