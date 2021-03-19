package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/*
    如果返回List<String>结果类型，那么就表示只能一次性返回所有值。要想能够表示可以异步计算的流式的值，
    可以使用Flow<String>类型，它非常类似与Sequence<String>类型，但其值是异步计算的

    Flow构建器是通过flow来实现的
    位于flow{}构建器中的代码时可以挂起的
    构建flow的函数无需使用suspend标识符，返回值时用过emit函数返回
    Flow里面的值时通过collect方法来收集的
 */

private fun func1(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    launch {
        for (i in 1..4){
            println("---------: $i")
            delay(200)
        }
    }
    // 异步执行
    func1().collect { println(it) }
}
