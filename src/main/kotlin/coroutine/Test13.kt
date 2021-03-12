package coroutine

import kotlinx.coroutines.*


/*

	* 有两种方式可以让计算代码变为可取消的：
	    * 周期性地调用一个挂起函数，该挂起函数会检查取消状态，比如使用yield函数
		* 显示地检查取消状态. 例如使用 isActive 变量

		isActive是协程的要给扩展属性，它是通过CoroutineScope对象添加的

 */

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch (Dispatchers.Default) {
        var nextPrintTime = startTime

        var i = 0

        // 显示地检查取消状态
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime){
                println("job: sleeping ${i++}")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300)
    println("================")

    // 这里的cancel没有起作用
    job.cancelAndJoin()
    println("-----------------")
}
