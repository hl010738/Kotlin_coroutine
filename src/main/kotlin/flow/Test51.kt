package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    Flow exception
 */

fun main() = runBlocking {
    try {
        exec1().collect {
            println(it)
            check(it <= 1) {
                "Collected $it"
            }
        }
    } catch (e: Throwable) {
        println("Catch $e")
    }
}

private fun exec1(): Flow<Int> = flow {
    for (i in 1..3){
        println("Emitting $i")
        emit(i)
    }
}
