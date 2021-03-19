package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer 缓冲

	* 当Flow 元素的发射emit 和 收集 collect 不在同一个协程当中时，emit和collect 每一个元素之间会需要一个等待
	* 在collect 之前先调用buffer() 将emit端的元素先缓存到buffer 中，可以减少等待时间.

	* Buffer 与 flowOn 之间存在一定的关系
		* 实际上，flowOn 运算符本质上在遇到需要改变CoroutineDispatcher 时也会使用同样的缓冲机制。

 */

fun main() = runBlocking {
    val time = measureTimeMillis {
        exec1().buffer().collect {
            delay(200)
            println(it)
        }
    }
    println(time)
}

private fun exec1(): Flow<Int> = flow{
    for (i in 1..4){
        delay(100) //模拟耗时操作
        emit(i)
    }
}

