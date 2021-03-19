package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/*
	Flow的完成

	Kotlin提供了2种方式来实现Flow的完成

	命令式
 */

fun main() = runBlocking {
    try {
        exec1().collect { println(it) }
    } finally {
        println("==========")
    }
}

private fun exec1(): Flow<Int> = (1..10).asFlow()

