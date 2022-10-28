package com.github.ch8n.recursion.impl

import com.github.ch8n.recursion.TailRecursion

internal class TailRecursionImpl : TailRecursion {
    override fun repeat(times: Int, step: Int, action: (step: Int) -> Unit) {
        if (times > 0) {
            action.invoke(step)
            repeat(times = times - 1, step = step + 1, action = action)
        }
    }

    override fun <T> List<T>.onEach(index: Int, action: (item: T) -> Unit) {
        if (index <= lastIndex) {
            action.invoke(get(index))
            onEach(index + 1, action)
        }
    }

    override fun <T> List<T>.onReversed(index: Int, action: (item: T) -> Unit) {
        val currentIndex = lastIndex - index
        if (currentIndex >= 0) {
            action.invoke(get(currentIndex))
            onReversed(index + 1, action)
        }
    }

    override fun fibonacci(first: Int, second: Int, target: Int, inclusive: Boolean): List<Int> {
        val accumulator = mutableListOf<Int>()

        if (inclusive) {
            accumulator.add(first)
            accumulator.add(second)
        }

        if (target > 0) {
            val sum = first + second
            accumulator.add(sum)
            accumulator.addAll(
                fibonacci(
                    first = second,
                    second = sum,
                    target = target - 1,
                    inclusive = false
                )
            )
        }
        return accumulator
    }

}
