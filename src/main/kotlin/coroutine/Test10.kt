package coroutine

/*
    lambda表达式在只有一个参数时不需要显式传递
 */

fun main() {
    test1(3, action = {
        println("test1")
    })
    test2(3, action = {
        println(it)
    })
}

fun test1(int: Int, action:() -> Unit){}

fun test2(int: Int, action:(Int) -> Unit){}