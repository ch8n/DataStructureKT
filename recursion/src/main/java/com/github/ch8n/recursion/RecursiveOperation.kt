package com.github.ch8n.recursion


interface RecursiveOperation {
    fun repeat(times: Int, step: Int = 0, action: (step: Int) -> Unit)
    fun <T> List<T>.onEach(index: Int = 0, action: (item: T) -> Unit)
    fun <T> List<T>.onReversed(index: Int = 0, action: (item: T) -> Unit)
}

interface HeadRecursion : RecursiveOperation
interface TailRecursion : RecursiveOperation {
    fun fibonacci(first: Int, second: Int, target: Int = 5, inclusive: Boolean = false): List<Int>
}
