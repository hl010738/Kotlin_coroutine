package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/*
    Flow Context (Flow上下文)

	* 使用 flow{ }.flowOn(Dispatchers.Default) 运算符 将Flow 元素的发射emit 放置到另外的协程当中，使得Flow 元素的发射emit 和 收集 collect 不在同一个协程当中
	* 需要注意的是：flowOn() 运算符改变了Flow本身默认的顺序。
	* flowOn 运算符本质上会改变上下文中的CoroutineDispatcher，并为上游的flow创建一个协程。
 */

private fun exec1(): Flow<Int> = flow{
    for (i in 1..4){
        Thread.sleep(100)
        log("----------: $i")
        emit(i)
    }
    // 将Flow元素的emit放置到另外的协程
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    exec1().collect { log("=========: $it") }
}

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")
