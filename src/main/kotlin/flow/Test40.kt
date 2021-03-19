package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
    transform
 */

fun main() = runBlocking {
    (1..10).asFlow().transform {
        emit("=======: $it")
        emit(exec(it))
        emit("-------------")
    }.collect { println(it) }
}

private suspend fun exec(input: Int): String {
    delay(100)
    return "output $input"
}
