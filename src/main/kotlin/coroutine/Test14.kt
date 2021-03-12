package coroutine

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    使用finally关闭资源

    join函数与CancelAndJoin函数都会等待所有清理动作完成才继续往下执行
 */

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(100){ a ->
                println("-----------${a}")
                delay(300)
            }
        } finally {
            println("finally")
        }
    }
    delay(1000)
    println("=============")

    job.cancelAndJoin()
    println("+++++++++++++")
}
