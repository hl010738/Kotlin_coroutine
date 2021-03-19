package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/*

	* Flow的取消
		* Flow的取消实际上与协程的取消之间是一种协同的关系；对于Flow来说，它自身并没有引入任何新的取消点；它对于取消是完全透明的。
		* Flow的调用collect函数是可以取消的，前提是Flow在一个可取消的挂起函数(例如：delay) 中被挂起了。没有其他方式取消Flow的执行。
 */

private fun func(): Flow<Int> = flow {
    for (i in 1..4){
        delay(100)
        println("========= $i")
        emit(i)
    }
}

fun main() = runBlocking {
    withTimeoutOrNull(280){
        func().collect { println(it)}
    }

    println("----------")
}
