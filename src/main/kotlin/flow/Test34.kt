package flow


/*
    直接返回一个集合的做法有2个特点

    1. 方法本身时阻塞的，即主线程会进入到该方法中执行，一直执行到该方法返回为止
    2. 集合本身是一次性返回给调用端的，即集合中的全部元素均已经获取到后才一次性返回给调用端。
 */

fun main() {
    func1().forEach { println(it)}
}

private fun func1(): List<String> = listOf("aaa", "bbb", "ccc", "ddd")
