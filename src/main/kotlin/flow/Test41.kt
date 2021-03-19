package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

/*
    限定大小的中间操作
 */

fun main() = runBlocking{

    // 这里只获取前2个返回值
    // 2个返回值之后的代码不再执行
    exec().take(2).collect { println(it) }
}

fun exec(): Flow<Int> = flow {
    emit(1)
    emit(2)
    // 这里之后的代码不在执行
    println("==========")
    emit(3)
}
