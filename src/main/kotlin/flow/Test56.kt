package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
    类似与catch运算符，onCompletion只会看到来自与Flow上游的异常
    但是不会看到Flow下游的异常
 */

fun main() = runBlocking {
    exec1().onCompletion { cause -> println("Exception: $cause") }
        .collect {
            check( it <= 1) {"Collected: $it"}
            println(it)
        }
}

private fun exec1(): Flow<Int> = (1..10).asFlow()
