package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    Flatten Flow

    Flow<Flow<Int>> -> Flow<Int>
 */

private fun exec1(i: Int): Flow<String> = flow{
    emit("$i, First")
    delay(500)
    emit("$i, second")
}

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()

    (1..3).asFlow().onEach { delay(100)}
        .flatMapConcat { exec1(it) }
        .collect { println("$it at ${System.currentTimeMillis() - startTime} ms") }
}
