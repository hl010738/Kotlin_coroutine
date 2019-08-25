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
    test1(3, ::test3)
    test2(3, ::test4)
    test5(3, ::test6)

}

fun test1(int: Int, action:() -> Unit){}

fun test2(int: Int, action:(Int) -> Unit){}

fun test3(){}

fun test4(x: Int){}

fun test5(x: Int, action: (Int, Int) -> Unit){action(1, 2)}

fun test6(x: Int, y: Int){ println(x + y) }