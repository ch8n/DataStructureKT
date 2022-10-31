package com.github.ch8n.recursion


interface RecursiveOperation {
    fun repeat(times: Int, step: Int = 0, action: (step: Int) -> Unit)
    fun <T> List<T>.onEach(index: Int = 0, action: (item: T) -> Unit)
    fun <T> List<T>.onReversed(index: Int = 0, action: (item: T) -> Unit)
    fun factorial(target: Int): Int
    fun Int.power(times: Int): Int

    fun List<Int>.sum(step: Int = 0): Int
}

interface HeadRecursion : RecursiveOperation

interface TailRecursion : RecursiveOperation {

    /**
     * Fibonacci series -> 0,0,1,2,3,5,8,13....
     * we compute sum first then recurse thus no head recursion only tail
     * if inclusive true then first and second will be added to result
     * **/
    fun fibonacci(first: Int, second: Int, target: Int = 5, inclusive: Boolean = false): List<Int>
    fun <I, R> List<I>.accumulate(): R
}
