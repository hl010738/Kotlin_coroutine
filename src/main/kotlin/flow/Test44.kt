package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    Flow Context (Flow上下文)

    Flow的collect动作总是发生再调用协程的上下文当中
 */

fun main() = runBlocking {
    exec1().collect { log("===========: $it") }
}

private fun exec1(): Flow<Int> = flow {
    log("---------")

    for (i in 1..3){
        emit(i)
    }
}

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")
