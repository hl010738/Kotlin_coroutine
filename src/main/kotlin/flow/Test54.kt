package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
	Flow的完成

	Kotlin提供了2种方式来实现Flow的完成

	声明式
 */

fun main() = runBlocking {

    // onCompletion的代码会在Flow完成时才调用
 exec1().onCompletion { println("onCompletion") }
        .collect { println(it) }
}


private fun exec1(): Flow<Int> = (1..10).asFlow()
