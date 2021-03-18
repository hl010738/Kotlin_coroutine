package flow


/*
	* Sequence（序列）
		* 如果在获取每一个元素时都需要执行一定的计算，这种计算是一种阻塞行为，将计算后的多个结果返回给调用端。
	* 序列的特点
		* 序列中的数据并非像集合一次性返回给调用端，而是计算完一个数据就返回一个数据
		* 序列中的计算过程会使用主线程来进行，因此会阻塞主线程的执行。
 */

fun main(){
    func1().forEach { println(it) }
}


private fun func1(): Sequence<Int> = sequence {
    for (i in 100 .. 105){
        Thread.sleep(1000)
        yield(i)
    }
}
