package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer 缓冲

 */

fun main() = runBlocking {
    val time = measureTimeMillis {
        exec1().collect {
            delay(200)
            println(it)
        }
    }
    println(time)
}

private fun exec1(): Flow<Int> = flow{
    for (i in 1..4){
        delay(100) //模拟耗时操作
        emit(i)
    }
}
