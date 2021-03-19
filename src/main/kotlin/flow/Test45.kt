package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/*
    Flow Context (Flow上下文)

    Flow在另外的协程中执行
 */

private fun exec1(): Flow<Int> = flow{
    // 将flow放到另外的协程中执行
    // 报错，不能用这种方式切换协程
    withContext(Dispatchers.Default){
        for (i in 1..4){
            Thread.sleep(100)
            emit(i)
        }
    }
}

fun main() = runBlocking {
    exec1().collect { println(it) }
}
