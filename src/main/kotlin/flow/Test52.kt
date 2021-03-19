package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
    Flow exception

    在收集端
 */

fun main() = runBlocking {
    try {
        exec1().collect { println(it) }
    } catch (e: Throwable) {
        println("Catch $e")
    }
}

private fun exec1(): Flow<String> = flow{
    for (i in 1..3){
        println("Emitting $i")
        emit(i)
    }
}.map {
    check(it <= 1) {"Crash on $it"}
    "string $it"
}

