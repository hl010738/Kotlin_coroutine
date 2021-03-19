package flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/*
 onCompletion中间操作的一个优势在于它有一个可空的Throwable参数
 可用坐确定Flow的collect操作是正常完成还是异常完成
 */

private fun exec1(): Flow<Int> = flow{
    emit(1)
    throw RuntimeException()
}

fun main() = runBlocking {
    exec1().onCompletion { cause -> if (null != cause) println("Exception") }
        .catch { cause -> println("catch") }
        .collect { println(it) }
}
