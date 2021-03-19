package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*

	* Flow 的中间运算符
		* Flow的中间运算符的思想与Java Stream 完全一致
		* Flow 与 Sequence 之间在中间运算符上的重要差别在于：对于Flow来说，这些中间运算符内的代码块是可以调用挂起函数的
 */

fun main() = runBlocking {
    (1..10).asFlow().map { exec(it) }.collect { println(it) }
}


private suspend fun exec(input: Int): String {
    delay(100)
    return "output $input"
}
