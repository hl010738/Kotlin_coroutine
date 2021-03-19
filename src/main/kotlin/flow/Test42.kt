package flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

/*
	* Flow的终止操作
		* Flow的终止操作都是挂起函数，终止操作才会真正开始执行流的收集
 */

fun main() = runBlocking{
    val result = (1..4).asFlow()
        .map { it * it }
        .reduce{a, b -> a + b}
    println(result)
}
