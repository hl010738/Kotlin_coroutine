package coroutine3

import kotlinx.coroutines.*

/*
    与对象相关的协程，在对象销毁时协程也一并销毁
 */

// 定义类
class Activity: CoroutineScope by CoroutineScope(Dispatchers.Default) {

    fun destroy(){
        cancel()
    }

    fun doSomething(){
        repeat(8) {a ->
            launch {
                delay((a + 1) * 300L)
                println("===========")
            }
        }
    }
}

fun main() = runBlocking {
    val activity = Activity()
    activity.doSomething()

    println("协程启动")
    delay(1300)

    println("Activity 销毁")
    activity.destroy()

    delay(9000)
}
